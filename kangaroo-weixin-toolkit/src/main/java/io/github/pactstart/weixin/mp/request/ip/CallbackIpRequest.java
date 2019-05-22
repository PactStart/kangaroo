package io.github.pactstart.weixin.mp.request.ip;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.request.Request;
import io.github.pactstart.weixin.mp.response.ip.CallbackIpResponse;
import org.apache.http.HttpEntity;

/**
 * 获取微信服务器的IP地址列表
 * Created by Di.Lei on 2017/7/26.
 */
public class CallbackIpRequest extends Request<CallbackIpResponse> {

    private String accessToken;

    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    public String getRequestPath() {
        return "/cgi-bin/getcallbackip?access_token=" + accessToken;
    }

    public HttpEntity getRequestEntity() {
        return null;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
