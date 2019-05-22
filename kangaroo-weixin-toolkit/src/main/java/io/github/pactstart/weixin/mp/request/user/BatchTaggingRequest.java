package io.github.pactstart.weixin.mp.request.user;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.response.DefaultJsonResponse;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.util.List;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class BatchTaggingRequest extends AbstractAccessTokenRequest<DefaultJsonResponse> {

    private int tagId;

    private List<String> openidList;

    public BatchTaggingRequest(int tagId, List<String> openidList) {
        this.tagId = tagId;
        this.openidList = openidList;
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/tags/members/batchtagging?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tagid", tagId);
        jsonObject.put("openid_list", openidList);
        return new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
    }
}
