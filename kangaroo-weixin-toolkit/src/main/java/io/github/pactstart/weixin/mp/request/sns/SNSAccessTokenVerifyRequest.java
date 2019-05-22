package io.github.pactstart.weixin.mp.request.sns;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.request.Request;
import io.github.pactstart.weixin.common.response.DefaultJsonResponse;
import org.apache.http.HttpEntity;

/**
 * 检验授权凭证（access_token）是否有效
 * Created by Di.Lei on 2017/8/12.
 */
public class SNSAccessTokenVerifyRequest extends Request<DefaultJsonResponse> {

    private String accessToken;

    private String openid;

    public SNSAccessTokenVerifyRequest(String accessToken, String openid) {
        this.accessToken = accessToken;
        this.openid = openid;
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getRequestPath() {
        return "/sns/auth?access_token=" + accessToken + "&openid=" + openid;
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }
}
