package io.github.pactstart.weixin.mp.request.user;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.user.UserInfoGetResponse;
import org.apache.http.HttpEntity;

/**
 * 用户和公众号产生消息交互或关注后事件推送后，才能根据用户OpenID来获取用户基本信息
 * Created by Di.Lei on 2017/8/12.
 */
public class UserInfoGetRequest extends AbstractAccessTokenRequest<UserInfoGetResponse> {

    private String openid;

    public UserInfoGetRequest(String openid) {
        this.openid = openid;
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/user/info?access_token=" + getAccessToken() + "&openid=" + openid + "&lang=zh_CN";
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
