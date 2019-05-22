package io.github.pactstart.http.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

public class HttpUtils {
    public static String defaultEncoding = "UTF-8";
    private static Log logger = LogFactory.getLog(HttpUtils.class);
    private static int bufferSize = 1024;
    private static ObjectMapper objMapper = new ObjectMapper();
    private static XmlMapper xmlMapper;

    static {
        objMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objMapper.enable(new Feature[]{Feature.ALLOW_COMMENTS});
        objMapper.enable(new Feature[]{Feature.ALLOW_SINGLE_QUOTES});
        objMapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        xmlMapper = new XmlMapper(module);
        xmlMapper.setSerializationInclusion(Include.NON_DEFAULT);
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private HttpRequestBase request;
    private EntityBuilder builder;
    private MultipartEntityBuilder meBuilder;
    private URIBuilder uriBuilder;
    private int type;
    private Builder config;
    private HttpClientBuilder clientBuilder;
    private ConnectionConfig connConfig;
    private SocketConfig socketConfig;
    private ConnectionSocketFactory plainSF;
    private SSLContext sslContext;
    private LayeredConnectionSocketFactory sslSF;
    private Registry<ConnectionSocketFactory> registry;
    private PoolingHttpClientConnectionManager connManager;
    private CloseableHttpClient httpClient;
    private volatile CookieStore cookieStore;
    private HttpHost httpProxy;
    private HttpRoutePlanner routePlanner;

    private HttpUtils(HttpRequestBase request) {
        this.request = request;
        this.clientBuilder = HttpClientBuilder.create();
        this.config = RequestConfig.custom().setCookieSpec("default");
        this.connConfig = ConnectionConfig.custom().setCharset(Charset.forName(defaultEncoding)).build();
        this.socketConfig = SocketConfig.custom().setSoTimeout(100000).build();
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.create();
        this.plainSF = new PlainConnectionSocketFactory();
        registryBuilder.register("http", this.plainSF);

        try {
            TrustManager manager = new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }
            };
            this.sslContext = SSLContext.getInstance("TLS");
            this.sslContext.init((KeyManager[]) null, new TrustManager[]{manager}, (SecureRandom) null);
            this.sslSF = new SSLConnectionSocketFactory(this.sslContext, NoopHostnameVerifier.INSTANCE);
            registryBuilder.register("https", this.sslSF);
        } catch (Exception var4) {
            throw new RuntimeException(var4);
        }

        this.registry = registryBuilder.build();
        this.connManager = new PoolingHttpClientConnectionManager(this.registry);
        this.connManager.setDefaultConnectionConfig(this.connConfig);
        this.connManager.setDefaultSocketConfig(this.socketConfig);
        this.cookieStore = new BasicCookieStore();
        if (request instanceof HttpPost) {
            this.type = 1;
            this.builder = EntityBuilder.create().setParameters(new ArrayList());
        } else if (request instanceof HttpGet) {
            this.type = 2;
            this.uriBuilder = new URIBuilder();
        } else if (request instanceof HttpPut) {
            this.type = 3;
            this.builder = EntityBuilder.create().setParameters(new ArrayList());
        } else if (request instanceof HttpDelete) {
            this.type = 4;
            this.uriBuilder = new URIBuilder();
        }

    }

    private HttpUtils(HttpRequestBase request, HttpUtils clientUtils) {
        this(request);
        this.httpClient = clientUtils.httpClient;
        this.config = clientUtils.config;
        this.setHeaders(clientUtils.getAllHeaders());
        this.setCookieStore(clientUtils.cookieStore);
    }

    public static String readStream(InputStream in, String encoding) {
        if (in == null) {
            return null;
        } else {
            try {
                InputStreamReader inReader = null;
                if (encoding == null) {
                    inReader = new InputStreamReader(in, defaultEncoding);
                } else {
                    inReader = new InputStreamReader(in, encoding);
                }

                char[] buffer = new char[bufferSize];
                int readLen = 0;
                StringBuffer sb = new StringBuffer();

                while ((readLen = inReader.read(buffer)) != -1) {
                    sb.append(buffer, 0, readLen);
                }

                inReader.close();
                return sb.toString();
            } catch (IOException var6) {
                logger.error("读取返回内容出错", var6);
                return null;
            }
        }
    }

    private static HttpUtils create(HttpRequestBase request) {
        return new HttpUtils(request);
    }

    private static HttpUtils create(HttpRequestBase request, HttpUtils clientUtils) {
        return new HttpUtils(request, clientUtils);
    }

    public static HttpUtils post(String url) {
        return create(new HttpPost(url));
    }

    public static HttpUtils get(String url) {
        return create(new HttpGet(url));
    }

    public static HttpUtils put(String url) {
        return create(new HttpPut(url));
    }

    public static HttpUtils delete(String url) {
        return create(new HttpDelete(url));
    }

    public static HttpUtils post(URI uri) {
        return create(new HttpPost(uri));
    }

    public static HttpUtils get(URI uri) {
        return create(new HttpGet(uri));
    }

    public static HttpUtils post(String url, HttpUtils clientUtils) {
        return create(new HttpPost(url), clientUtils);
    }

    public static HttpUtils get(String url, HttpUtils clientUtils) {
        return create(new HttpGet(url), clientUtils);
    }

    public static HttpUtils post(URI uri, HttpUtils clientUtils) {
        return create(new HttpPost(uri), clientUtils);
    }

    public static HttpUtils get(URI uri, HttpUtils clientUtils) {
        return create(new HttpGet(uri), clientUtils);
    }

    private SSLContext setSSLContext(String keyStorePath, String keyStorepass) {
        FileInputStream instream = null;
        KeyStore trustStore = null;

        try {
            trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            instream = new FileInputStream(new File(keyStorePath));
            trustStore.load(instream, keyStorepass.toCharArray());
            this.sslContext = SSLContexts.custom().loadTrustMaterial(trustStore, new TrustSelfSignedStrategy()).build();
            RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.create();
            this.plainSF = new PlainConnectionSocketFactory();
            registryBuilder.register("http", this.plainSF);
            this.sslSF = new SSLConnectionSocketFactory(this.sslContext);
            registryBuilder.register("https", this.sslSF);
            this.registry = registryBuilder.build();
        } catch (Exception var14) {
            logger.error((Object) null, var14);
        } finally {
            try {
                instream.close();
            } catch (IOException var13) {
                logger.error((Object) null, var13);
            }

        }

        return this.sslContext;
    }

    public HttpUtils setParameters(NameValuePair... parameters) {
        if (this.builder != null) {
            this.builder.setParameters(parameters);
        } else {
            this.uriBuilder.setParameters(Arrays.asList(parameters));
        }

        return this;
    }

    public HttpUtils addParameter(String name, String value) {
        if (this.builder != null) {
            if (this.builder.getParameters() == null) {
                this.builder.setParameters(new NameValuePair[]{new BasicNameValuePair(name, value)});
            } else {
                this.builder.getParameters().add(new BasicNameValuePair(name, value));
            }
        } else {
            this.uriBuilder.addParameter(name, value);
        }

        return this;
    }

    public HttpUtils addParameters(NameValuePair... parameters) {
        if (this.builder != null) {
            if (this.builder.getParameters() == null) {
                this.builder.setParameters(parameters);
            } else {
                this.builder.getParameters().addAll(Arrays.asList(parameters));
            }
        } else {
            this.uriBuilder.addParameters(Arrays.asList(parameters));
        }

        return this;
    }

    public HttpUtils setParameters(Map<String, String> parameters) {
        NameValuePair[] values = new NameValuePair[parameters.size()];
        int i = 0;

        Entry parameter;
        for (Iterator i$ = parameters.entrySet().iterator(); i$.hasNext(); values[i++] = new BasicNameValuePair((String) parameter.getKey(), (String) parameter.getValue())) {
            parameter = (Entry) i$.next();
        }

        this.setParameters(values);
        return this;
    }

    public HttpUtils setParameter(File file) {
        if (this.builder != null) {
            this.builder.setFile(file);
            return this;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public HttpUtils setParameter(File file, NameValuePair... parameters) {
        this.meBuilder = MultipartEntityBuilder.create();
        NameValuePair[] arr$ = parameters;
        int len$ = parameters.length;

        for (int i$ = 0; i$ < len$; ++i$) {
            NameValuePair p = arr$[i$];
            this.meBuilder.addPart(p.getName(), new StringBody(p.getValue(), ContentType.TEXT_PLAIN));
        }

        FileBody fileBody = new FileBody(file);
        this.meBuilder.addPart("file", fileBody);
        return this;
    }

    public HttpUtils setParameter(byte[] binary) {
        if (this.builder != null) {
            this.builder.setBinary(binary);
            return this;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public HttpUtils setParameter(Serializable serializable) {
        if (this.builder != null) {
            this.builder.setSerializable(serializable);
            return this;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public HttpUtils setParameterJson(Object parameter) {
        if (this.builder != null) {
            try {
                this.setContentType(ContentType.APPLICATION_JSON);
                this.builder.setBinary(objMapper.writeValueAsBytes(parameter));
                return this;
            } catch (JsonProcessingException var3) {
                throw new RuntimeException(var3.getMessage(), var3);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public HttpUtils setParameterXml(Object parameter) {
        if (this.builder != null) {
            try {
                this.setContentType(ContentType.APPLICATION_XML);
                this.builder.setBinary(xmlMapper.writeValueAsBytes(parameter));
                return this;
            } catch (JsonProcessingException var3) {
                throw new RuntimeException(var3.getMessage(), var3);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public HttpUtils setParameter(InputStream stream) {
        if (this.builder != null) {
            this.builder.setStream(stream);
            return this;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public HttpUtils setParameter(String text) {
        if (this.builder != null) {
            this.builder.setText(text);
        } else {
            this.uriBuilder.setParameters(URLEncodedUtils.parse(text, Consts.UTF_8));
        }

        return this;
    }

    public HttpUtils setContentEncoding(String encoding) {
        if (this.builder != null) {
            this.builder.setContentEncoding(encoding);
        }

        return this;
    }

    public HttpUtils setContentType(ContentType contentType) {
        if (this.builder != null) {
            this.builder.setContentType(contentType);
        }

        return this;
    }

    public HttpUtils setContentType(String mimeType, Charset charset) {
        if (this.builder != null) {
            this.builder.setContentType(ContentType.create(mimeType, charset));
        }

        return this;
    }

    public HttpUtils addParameters(Map<String, String> parameters) {
        List<NameValuePair> values = new ArrayList(parameters.size());
        Iterator i$ = parameters.entrySet().iterator();

        while (i$.hasNext()) {
            Entry<String, String> parameter = (Entry) i$.next();
            values.add(new BasicNameValuePair((String) parameter.getKey(), (String) parameter.getValue()));
        }

        if (this.builder != null) {
            this.builder.getParameters().addAll(values);
        } else {
            this.uriBuilder.addParameters(values);
        }

        return this;
    }

    public HttpUtils addHeader(String name, String value) {
        this.request.addHeader(name, value);
        return this;
    }

    public HttpUtils addHeaders(Map<String, String> headers) {
        Iterator i$ = headers.entrySet().iterator();

        while (i$.hasNext()) {
            Entry<String, String> header = (Entry) i$.next();
            this.request.addHeader((String) header.getKey(), (String) header.getValue());
        }

        return this;
    }

    public HttpUtils setHeaders(Map<String, String> headers) {
        Header[] headerArray = new Header[headers.size()];
        int i = 0;

        Entry header;
        for (Iterator i$ = headers.entrySet().iterator(); i$.hasNext(); headerArray[i++] = new BasicHeader((String) header.getKey(), (String) header.getValue())) {
            header = (Entry) i$.next();
        }

        this.request.setHeaders(headerArray);
        return this;
    }

    public HttpUtils setHeaders(Header[] headers) {
        this.request.setHeaders(headers);
        return this;
    }

    public Header[] getAllHeaders() {
        return this.request.getAllHeaders();
    }

    public HttpUtils removeHeaders(String name) {
        this.request.removeHeaders(name);
        return this;
    }

    public HttpUtils removeHeader(Header header) {
        this.request.removeHeader(header);
        return this;
    }

    public HttpUtils removeHeader(String name, String value) {
        this.request.removeHeader(new BasicHeader(name, value));
        return this;
    }

    public boolean containsHeader(String name) {
        return this.request.containsHeader(name);
    }

    public HeaderIterator headerIterator() {
        return this.request.headerIterator();
    }

    public ProtocolVersion getProtocolVersion() {
        return this.request.getProtocolVersion();
    }

    public URI getURI() {
        return this.request.getURI();
    }

    public HttpUtils setURI(URI uri) {
        this.request.setURI(uri);
        return this;
    }

    public HttpUtils setURI(String uri) {
        return this.setURI(URI.create(uri));
    }

    public HttpUtils setCookieStore(CookieStore cookieStore) {
        if (cookieStore == null) {
            return this;
        } else {
            this.cookieStore = cookieStore;
            return this;
        }
    }

    public HttpUtils addCookie(Cookie... cookies) {
        if (cookies == null) {
            return this;
        } else {
            for (int i = 0; i < cookies.length; ++i) {
                this.cookieStore.addCookie(cookies[i]);
            }

            return this;
        }
    }

    public HttpUtils setSocketTimeout(int socketTimeout) {
        this.config.setSocketTimeout(socketTimeout);
        return this;
    }

    public HttpUtils setConnectTimeout(int connectTimeout) {
        this.config.setConnectTimeout(connectTimeout);
        return this;
    }

    public HttpUtils setConnectionRequestTimeout(int connectionRequestTimeout) {
        this.config.setConnectionRequestTimeout(connectionRequestTimeout);
        return this;
    }

    public HttpUtils setProxy(HttpHost proxy) {
        this.httpProxy = proxy;
        return this;
    }

    public HttpUtils setHttpRoutePlanner(HttpRoutePlanner routePlanner) {
        this.routePlanner = routePlanner;
        return this;
    }

    public ResponseWrap execute() {
        this.settingRequest();
        if (this.httpClient == null) {
            this.httpClient = this.clientBuilder.setProxy(this.httpProxy).setRoutePlanner(this.routePlanner).setDefaultCookieStore(this.cookieStore).setConnectionManager(this.connManager).build();
        }
        try {
            HttpClientContext context = HttpClientContext.create();
            CloseableHttpResponse response = this.httpClient.execute(this.request, context);
            return new ResponseWrap(this.httpClient, this.request, response, context, objMapper, xmlMapper);
        } catch (IOException var3) {
            this.shutdown();
            logger.error(var3.getMessage(), var3);
            throw new RuntimeException(var3.getMessage(), var3);
        }
    }

    public <T> T execute(ResponseHandler<? extends T> responseHandler) {
        this.settingRequest();
        if (this.httpClient == null) {
            this.httpClient = this.clientBuilder.build();
        }

        try {
            return this.httpClient.execute(this.request, responseHandler);
        } catch (IOException var3) {
            this.shutdown();
            logger.error(var3.getMessage(), var3);
            throw new RuntimeException(var3.getMessage(), var3);
        }
    }

    public void shutdown() {
        this.connManager.close();
    }

    private void settingRequest() {
        URI uri = null;
        if (this.uriBuilder != null) {
            try {
                uri = this.uriBuilder.setPath(this.request.getURI().toString()).build();
            } catch (URISyntaxException var5) {
                logger.warn(var5.getMessage(), var5);
            }
        }

        HttpEntity httpEntity = null;
        switch (this.type) {
            case 1:
                if (this.meBuilder != null) {
                    httpEntity = this.meBuilder.build();
                } else {
                    try {
                        if (this.builder.getParameters() != null && !this.builder.getParameters().isEmpty()) {
                            httpEntity = new UrlEncodedFormEntity(this.builder.getParameters(), "UTF-8");
                        } else {
                            httpEntity = this.builder.build();
                        }
                    } catch (UnsupportedEncodingException var6) {
                        var6.printStackTrace();
                    }
                }

                ((HttpPost) this.request).setEntity((HttpEntity) httpEntity);
                break;
            case 2:
                HttpGet get = (HttpGet) this.request;
                get.setURI(uri);
                break;
            case 3:
                httpEntity = this.builder.build();
                if (httpEntity.getContentLength() > 0L) {
                    ((HttpPut) this.request).setEntity(httpEntity);
                }
                break;
            case 4:
                HttpDelete delete = (HttpDelete) this.request;
                delete.setURI(uri);
        }

        this.clientBuilder.setDefaultCookieStore(this.cookieStore);
        this.request.setConfig(this.config.build());
    }
}