package io.github.pactstart.weixin.mp.request.user;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.user.UserListGetResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;

/**
 * 获取用户列表，只能拿到openid
 * Created by Di.Lei on 2017/8/12.
 */
public class UserListGetRequest extends AbstractAccessTokenRequest<UserListGetResponse> {

    private String nextOpenid;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getRequestPath() {
        StringBuilder sb = new StringBuilder();
        sb.append("/cgi-bin/user/get?access_token=").append(getAccessToken());
        if (StringUtils.isNoneBlank(nextOpenid)) {
            sb.append("&next_openid=").append(nextOpenid);
        }
        return sb.toString();
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }
}
