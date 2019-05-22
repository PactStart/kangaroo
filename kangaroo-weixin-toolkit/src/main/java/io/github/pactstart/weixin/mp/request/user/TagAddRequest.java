package io.github.pactstart.weixin.mp.request.user;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.user.TagAddResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class TagAddRequest extends AbstractAccessTokenRequest<TagAddResponse> {

    private String tagName;

    public TagAddRequest(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/tags/create?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject tag = new JSONObject();
        tag.put("name", tagName);
        JSONObject root = new JSONObject();
        root.put("tag", tag);
        return new StringEntity(root.toJSONString(), ContentType.APPLICATION_JSON);
    }
}
