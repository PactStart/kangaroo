package io.github.pactstart.weixin.mp.request.user;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.user.GetUserTagResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class GetUserTagRequest extends AbstractAccessTokenRequest<GetUserTagResponse> {

    private String openid;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/tags/getidlist?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        return new StringEntity("{\"openid\":\"" + openid + "\"}", ContentType.APPLICATION_JSON);
    }
}
