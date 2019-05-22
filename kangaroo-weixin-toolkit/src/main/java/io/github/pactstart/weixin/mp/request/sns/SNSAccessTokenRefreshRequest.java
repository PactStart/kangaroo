package io.github.pactstart.weixin.mp.request.sns;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.request.Request;
import io.github.pactstart.weixin.mp.response.sns.SNSAccessTokenResponse;
import org.apache.http.HttpEntity;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class SNSAccessTokenRefreshRequest extends Request<SNSAccessTokenResponse> {

    private String appid;

    private String refreshToken;

    public SNSAccessTokenRefreshRequest(String appid, String refreshToken) {
        this.appid = appid;
        this.refreshToken = refreshToken;
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getRequestPath() {
        return "/sns/oauth2/refresh_token?appid=" + appid + "&grant_type=refresh_token&refresh_token=" + refreshToken;
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }
}
