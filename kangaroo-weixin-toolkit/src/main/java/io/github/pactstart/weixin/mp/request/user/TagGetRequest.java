package io.github.pactstart.weixin.mp.request.user;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.user.TagGetResponse;
import org.apache.http.HttpEntity;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class TagGetRequest extends AbstractAccessTokenRequest<TagGetResponse> {
    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/tags/get?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }
}
