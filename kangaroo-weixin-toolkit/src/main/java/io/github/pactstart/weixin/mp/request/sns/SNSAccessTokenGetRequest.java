package io.github.pactstart.weixin.mp.request.sns;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.request.Request;
import io.github.pactstart.weixin.mp.response.sns.SNSAccessTokenResponse;
import org.apache.http.HttpEntity;

/**
 * 通过code换取网页授权access_token
 * Created by Di.Lei on 2017/8/12.
 */
public class SNSAccessTokenGetRequest extends Request<SNSAccessTokenResponse> {

    private String appid;

    private String secret;

    private String code;

    public SNSAccessTokenGetRequest(String appid, String secret, String code) {
        this.appid = appid;
        this.secret = secret;
        this.code = code;
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getRequestPath() {
        return "/sns/oauth2/access_token?appid=" + appid + "&secret=" + secret + "&code=" + code + "&grant_type=authorization_code";
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }
}
