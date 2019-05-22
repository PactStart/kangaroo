package io.github.pactstart.http;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;

public abstract class Response {

    private static ObjectMapper objMapper;
    private static XmlMapper xmlMapper;

    static {
        objMapper = new ObjectMapper();
        objMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);//设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        objMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objMapper.enable(Feature.ALLOW_COMMENTS);
        objMapper.enable(Feature.ALLOW_SINGLE_QUOTES);
        objMapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        xmlMapper = new XmlMapper(module);
        xmlMapper.setSerializationInclusion(Include.NON_DEFAULT);//设置序列化不包含Java对象中为空的属性
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    protected int errcode = 0;
    protected String errmsg;

    public boolean isOk() {
        return errcode == 0;
    }

    public int getErrcode() {
        return errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    /**
     * 处理请求结果
     *
     * @param entity
     * @throws IOException
     */
    public abstract void process(HttpEntity entity) throws IOException;

    /**
     * 获取响应内容为字节数组
     *
     * @return
     */
    protected byte[] getByteArray(HttpEntity entity) {
        try {
            return EntityUtils.toByteArray(entity);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            EntityUtils.consumeQuietly(entity);
        }
    }

    protected String getText(HttpEntity entity) {
        return getText(entity, Charset.forName("UTF-8"));
    }

    /**
     * 获取响应内容为String
     *
     * @param charSet 指定编码,不指定时使用UTF-8编码
     * @return
     */
    protected String getText(HttpEntity entity, Charset charSet) {
        try {
            return EntityUtils.toString(entity, charSet);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            EntityUtils.consumeQuietly(entity);
        }
    }

    /**
     * 获取JSON对象
     *
     * @param clazz
     * @return
     */
    protected <T> T getJson(HttpEntity entity, Class<T> clazz) {
        try {
            return objMapper.readValue(getByteArray(entity), clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 获取XML对象
     *
     * @param clazz
     * @return
     */
    protected <T> T getXml(HttpEntity entity, Class<T> clazz) {
        try {
            return xmlMapper.readValue(getByteArray(entity), clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
