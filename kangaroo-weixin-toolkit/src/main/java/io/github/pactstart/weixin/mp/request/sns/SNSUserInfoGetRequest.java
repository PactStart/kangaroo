package io.github.pactstart.weixin.mp.request.sns;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.request.Request;
import io.github.pactstart.weixin.mp.enums.Language;
import io.github.pactstart.weixin.mp.response.sns.SNSUserInfoGetResponse;
import org.apache.http.HttpEntity;

/**
 * 拉取用户信息(需scope为 snsapi_userinfo)
 * Created by Di.Lei on 2017/8/12.
 */
public class SNSUserInfoGetRequest extends Request<SNSUserInfoGetResponse> {

    private String accessToken;

    private String openid;

    private String lang = Language.ZH_CN.getValue();

    public SNSUserInfoGetRequest(String accessToken, String openid) {
        this.accessToken = accessToken;
        this.openid = openid;
    }

    public SNSUserInfoGetRequest(String accessToken, String openid, String lang) {
        this.accessToken = accessToken;
        this.openid = openid;
        this.lang = lang;
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getRequestPath() {
        return "/sns/userinfo?access_token=" + accessToken + "&openid=" + openid + "&lang=" + lang;
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }
}
