package io.github.pactstart.http.wrapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;

public class ResponseWrap {
    private CloseableHttpResponse response;
    private CloseableHttpClient httpClient;
    private HttpEntity entity;
    private HttpRequestBase request;
    private HttpClientContext context;
    private ObjectMapper objMapper;
    private XmlMapper xmlMapper;

    public ResponseWrap(CloseableHttpClient httpClient, HttpRequestBase request, CloseableHttpResponse response, HttpClientContext context, ObjectMapper mapper, XmlMapper xmlMapper) {
        this.response = response;
        this.httpClient = httpClient;
        this.request = request;
        this.context = context;
        this.objMapper = mapper;
        this.xmlMapper = xmlMapper;

        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                this.entity = new BufferedHttpEntity(entity);
            } else {
                this.entity = new BasicHttpEntity();
            }

            EntityUtils.consumeQuietly(entity);
            this.response.close();
        } catch (IOException var8) {
            var8.printStackTrace();
        }

    }

    public void abort() {
        this.request.abort();
    }

    public List<URI> getRedirectLocations() {
        return this.context.getRedirectLocations();
    }

    public void shutdown() {
        this.httpClient.getConnectionManager().shutdown();
    }

    public String getString() {
        return this.getString(Consts.UTF_8);
    }

    public String getString(Charset defaultCharset) {
        try {
            return EntityUtils.toString(this.entity, defaultCharset);
        } catch (IOException | ParseException var3) {
            var3.printStackTrace();
            throw new RuntimeException(var3.getMessage(), var3);
        }
    }

    public String getStringForceCharset(Charset forceCharset) {
        try {
            Args.notNull(entity, "Entity");
            InputStream instream = entity.getContent();
            if (instream == null) {
                return null;
            } else {
                try {
                    Args.check(entity.getContentLength() <= 2147483647L, "HTTP entity too large to be buffered in memory");
                    int i = (int) entity.getContentLength();
                    if (i < 0) {
                        i = 4096;
                    }
                    Reader reader = new InputStreamReader(instream, forceCharset);
                    CharArrayBuffer buffer = new CharArrayBuffer(i);
                    char[] tmp = new char[1024];

                    int l;
                    while ((l = reader.read(tmp)) != -1) {
                        buffer.append(tmp, 0, l);
                    }

                    String var9 = buffer.toString();
                    return var9;
                } finally {
                    instream.close();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public Header getContentType() {
        return this.entity.getContentType();
    }

    public Charset getCharset() {
        ContentType contentType = ContentType.get(this.entity);
        return contentType == null ? null : contentType.getCharset();
    }

    public byte[] getByteArray() {
        try {
            return EntityUtils.toByteArray(this.entity);
        } catch (IOException | ParseException var2) {
            var2.printStackTrace();
            throw new RuntimeException(var2.getMessage(), var2);
        }
    }

    public int getContentLength() {
        return Long.valueOf(this.entity.getContentLength()).intValue();
    }

    public HttpEntity getEntity() {
        return entity;
    }

    public Header[] getAllHeaders() {
        return this.response.getAllHeaders();
    }

    public Header[] getHeaders(String name) {
        return this.response.getHeaders(name);
    }

    public int getStatusCode() {
        return this.response.getStatusLine().getStatusCode();
    }

    public void removeHeaders(String name) {
        this.response.removeHeaders(name);
    }

    public void removeHeader(Header header) {
        this.response.removeHeader(header);
    }

    public void removeHeader(String name, String value) {
        this.response.removeHeader(new BasicHeader(name, value));
    }

    public boolean containsHeader(String name) {
        return this.response.containsHeader(name);
    }

    public HeaderIterator headerIterator() {
        return this.response.headerIterator();
    }

    public ProtocolVersion getProtocolVersion() {
        return this.response.getProtocolVersion();
    }

    public CookieStore getCookieStore() {
        return this.context.getCookieStore();
    }

    public List<Cookie> getCookies() {
        return this.getCookieStore().getCookies();
    }

    public InputStream getInputStream() {
        try {
            return this.entity.getContent();
        } catch (IOException | IllegalStateException var2) {
            var2.printStackTrace();
            throw new RuntimeException(var2.getMessage(), var2);
        }
    }

    public BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(this.getInputStream(), this.getCharset()));
    }

    public void transferTo(String filePth) {
        this.transferTo(new File(filePth));
    }

    public void transferTo(File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            Throwable var3 = null;

            try {
                this.transferTo((OutputStream) fileOutputStream);
            } catch (Throwable var13) {
                var3 = var13;
                throw var13;
            } finally {
                if (fileOutputStream != null) {
                    if (var3 != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable var12) {
                            var3.addSuppressed(var12);
                        }
                    } else {
                        fileOutputStream.close();
                    }
                }

            }

        } catch (Exception var15) {
            throw new RuntimeException(var15.getMessage(), var15);
        }
    }

    public void transferTo(OutputStream outputStream) {
        try {
            this.entity.writeTo(outputStream);
        } catch (Exception var3) {
            var3.printStackTrace();
            throw new RuntimeException(var3.getMessage(), var3);
        }
    }

    public <T> T getJson(Class<T> clazz) {
        try {
            return this.objMapper.readValue(this.getByteArray(), clazz);
        } catch (IOException var3) {
            var3.printStackTrace();
            throw new RuntimeException(var3.getMessage(), var3);
        }
    }

    public <T> T getXml(Class<T> clazz) {
        try {
            return this.xmlMapper.readValue(this.getByteArray(), clazz);
        } catch (IOException var3) {
            var3.printStackTrace();
            throw new RuntimeException(var3.getMessage(), var3);
        }
    }

    public <T> List<T> getJsonList(Class<?> clazz) {
        try {
            return (List) this.objMapper.readValue(this.getByteArray(), new TypeReference<List<T>>() {
            });
        } catch (IOException var3) {
            var3.printStackTrace();
            throw new RuntimeException(var3.getMessage(), var3);
        }
    }
}
