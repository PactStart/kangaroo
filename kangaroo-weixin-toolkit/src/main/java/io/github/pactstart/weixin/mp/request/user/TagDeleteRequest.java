package io.github.pactstart.weixin.mp.request.user;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.response.DefaultJsonResponse;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class TagDeleteRequest extends AbstractAccessTokenRequest<DefaultJsonResponse> {

    private int id;

    public TagDeleteRequest(int id) {
        this.id = id;
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/tags/delete?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        String json = "{\"tag\":{\"id\":" + id + "}}";
        return new StringEntity(json, ContentType.APPLICATION_JSON);
    }
}
