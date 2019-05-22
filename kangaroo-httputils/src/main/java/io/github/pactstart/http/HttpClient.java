package io.github.pactstart.http;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.methods.*;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public abstract class HttpClient implements Closeable {

    private final static String defaultEncoding = "UTF-8";
    private static Log logger = LogFactory.getLog(HttpClient.class);
    private static Registry<ConnectionSocketFactory> registry = createRegistry();
    private CloseableHttpClient httpClient;
    private HttpRequestRetryHandler retryHandler = new DefaultHttpRequestRetryHandler(3, true);

    public HttpClient() {
        // 设置连接管理器
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(registry);
        // 设置默编码
        ConnectionConfig connConfig = ConnectionConfig.custom().setCharset(Charset.forName(defaultEncoding)).build();
        connManager.setDefaultConnectionConfig(connConfig);
        // 从服务器读取数据的timeout
        SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(100000).build();
        connManager.setDefaultSocketConfig(socketConfig);
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        clientBuilder.setConnectionManager(connManager);
        clientBuilder.setRetryHandler(retryHandler);
        httpClient = clientBuilder.build();
    }

    private static Registry<ConnectionSocketFactory> createRegistry() {
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory>create();
        PlainConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();
        registryBuilder.register("http", plainSF);
        // 指定信任密钥存储对象和连接套接字工厂
        try {
            TrustManager manager = new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }
            };
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{manager}, null);
            SSLConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(sslContext,
                    NoopHostnameVerifier.INSTANCE);
            registryBuilder.register("https", sslSF);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return registryBuilder.build();
    }

    /**
     * 获取请求地址根路径
     *
     * @return
     */
    public abstract String getUrlRoot();

    /**
     * 执行请求
     *
     * @param request
     * @return
     * @throws HttpException
     */
    public <T extends Response> T execute(Request<T> request) throws HttpException {
        try {
            HttpRequestBase httpRequest = configRequest(request);
            HttpResponse httpResponse = httpClient.execute(httpRequest);
            int status = httpResponse.getStatusLine().getStatusCode();
            if (status == 200) {
                ParameterizedType type = (ParameterizedType) request.getClass().getGenericSuperclass();
                @SuppressWarnings("unchecked")
                Class<T> responseClass = (Class<T>) type.getActualTypeArguments()[0];
                T response = responseClass.newInstance();
                response.process(httpResponse.getEntity());
                if (!response.isOk()) {
                    logger.error("请求【" + getUrlRoot() + request.getRequestPath() + "】接口返回结果异常:" + response.getErrcode()
                            + "," + response.getErrmsg());
                }
                return response;
            } else {
                throw new HttpException("调用结果异常，响应状态码:" + status);
            }
        } catch (Exception e) {
            logger.error("请求【" + getUrlRoot() + request.getRequestPath() + "】接口失败", e);
            throw new HttpException("请求【" + request.getRequestPath() + "】接口失败");
        }
    }

    /**
     * 配置请求
     *
     * @param request
     */
    private <T extends Response> HttpRequestBase configRequest(Request<T> request) {
        HttpRequestBase httpRequest;
        HttpEntity entity = request.getRequestEntity();
        String url = getUrlRoot().concat(request.getRequestPath());
        if (request.getRequestMethod() == RequestMethod.GET) {
            httpRequest = new HttpGet(url);
        } else if (request.getRequestMethod() == RequestMethod.POST) {
            httpRequest = new HttpPost(url);
        } else if (request.getRequestMethod() == RequestMethod.DELETE) {
            httpRequest = new HttpDelete(url);
        } else {
            httpRequest = new HttpPut(url);
        }
        // 设置实体内容
        if (entity != null && httpRequest instanceof HttpEntityEnclosingRequest) {
            ((HttpEntityEnclosingRequest) httpRequest).setEntity(entity);
        }
        Builder requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.DEFAULT);
        requestConfig.setConnectTimeout(request.getConnectTimeout());// 和服务器建立连接的timeout
        requestConfig.setSocketTimeout(request.getSocketTimeout());// 从服务器读取数据的timeout
        requestConfig.setConnectionRequestTimeout(request.getConnectionRequestTimeout());// 从连接池获取连接的timeout
        httpRequest.setConfig(requestConfig.build());
        try {
            Field retryCountField = retryHandler.getClass().getDeclaredField("retryCount");
            retryCountField.setAccessible(true);
            retryCountField.set(retryHandler, request.getRetryTimes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpRequest;
    }

    /**
     * 关闭请求连接, 释放资源
     */
    @Override
    public void close() {
        try {
            if (httpClient != null) {
                httpClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
