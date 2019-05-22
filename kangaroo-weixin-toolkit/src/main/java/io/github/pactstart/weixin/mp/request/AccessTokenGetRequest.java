package io.github.pactstart.weixin.mp.request;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.request.Request;
import io.github.pactstart.weixin.mp.response.AccessTokenGetResponse;
import org.apache.http.HttpEntity;

/**
 * 获取公众号access_token
 * Created by Di.Lei on 2017/7/26.
 */
public class AccessTokenGetRequest extends Request<AccessTokenGetResponse> {

    private String appid;

    private String secret;

    private String grantType = "client_credential";

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/token?appid=" + appid
                + "&secret=" + secret +
                "&grant_type=" + grantType;
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

}
