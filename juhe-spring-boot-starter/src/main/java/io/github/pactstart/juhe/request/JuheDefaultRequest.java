package io.github.pactstart.juhe.request;

import io.github.pactstart.http.Request;
import io.github.pactstart.http.RequestMethod;
import io.github.pactstart.http.Response;
import io.github.pactstart.juhe.autoconfigure.JuheProperties;
import org.apache.http.HttpEntity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public abstract class JuheDefaultRequest<T extends Response> extends Request<T> {

    private static JuheProperties juheProperties;

    public static JuheProperties getJuheProperties() {
        return juheProperties;
    }

    public static void setJuheProperties(JuheProperties juhe) {
        juheProperties = juhe;
    }

    //将map型转为请求参数型
    public static String urlEncode(Map<String, Object> data) {
        if (data == null || data.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("&");
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }
}
