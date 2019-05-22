package io.github.pactstart.weixin.mp.request.material;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.response.DefaultJsonResponse;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * 删除永久图文素材
 * Created by Di.Lei on 2017/8/5.
 */
public class MaterialDeleteRequest extends AbstractAccessTokenRequest<DefaultJsonResponse> {

    private String meidaId;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/material/del_material?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("media_id", meidaId);
        return new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
    }

    public String getMeidaId() {
        return meidaId;
    }

    public void setMeidaId(String meidaId) {
        this.meidaId = meidaId;
    }
}
