package io.github.pactstart.weixin.mp.request.material;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.enums.MaterialType;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.material.MaterialBatchGetResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * Created by Di.Lei on 2017/8/5.
 */
public class MaterialBatchGetRequest extends AbstractAccessTokenRequest<MaterialBatchGetResponse> {

    private MaterialType type;

    /**
     * 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
     */
    private int offset;

    /**
     * 返回素材的数量，取值在1到20之间
     */
    private int count;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/material/batchget_material?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", type.name());
        jsonObject.put("offset", offset);
        jsonObject.put("count", count);
        return new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
    }

    public MaterialType getType() {
        return type;
    }

    public void setType(MaterialType type) {
        this.type = type;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
