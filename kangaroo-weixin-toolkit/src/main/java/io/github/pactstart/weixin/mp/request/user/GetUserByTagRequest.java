package io.github.pactstart.weixin.mp.request.user;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.user.GetUserByTagResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class GetUserByTagRequest extends AbstractAccessTokenRequest<GetUserByTagResponse> {

    private int tagId;

    private String nextOpenid;

    public GetUserByTagRequest(int tagId) {
        this.tagId = tagId;
    }

    public GetUserByTagRequest(int tagId, String nextOpenid) {
        this.tagId = tagId;
        this.nextOpenid = nextOpenid;
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/user/tag/get?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tagid", tagId);
        jsonObject.put("next_openid", nextOpenid);
        return new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
    }
}
