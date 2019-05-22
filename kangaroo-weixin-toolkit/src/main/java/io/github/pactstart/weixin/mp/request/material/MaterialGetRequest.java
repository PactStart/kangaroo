package io.github.pactstart.weixin.mp.request.material;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.material.MaterialGetResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * 获取永久素材
 * Created by Di.Lei on 2017/8/5.
 */
public class MaterialGetRequest extends AbstractAccessTokenRequest<MaterialGetResponse> {

    private String mediaId;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/material/get_material?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("media_id", mediaId);
        return new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
