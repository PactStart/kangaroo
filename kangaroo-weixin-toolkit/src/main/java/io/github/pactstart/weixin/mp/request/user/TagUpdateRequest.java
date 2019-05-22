package io.github.pactstart.weixin.mp.request.user;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.response.DefaultJsonResponse;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class TagUpdateRequest extends AbstractAccessTokenRequest<DefaultJsonResponse> {

    private int id;

    private String name;

    public TagUpdateRequest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/tags/update?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("name", name);
        JSONObject tag = new JSONObject();
        tag.put("tag", jsonObject);
        return new StringEntity(tag.toJSONString(), ContentType.APPLICATION_JSON);
    }

}
