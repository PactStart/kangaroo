package io.github.pactstart.weixin.mp.request.comment;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.comment.CommentListResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * Created by Di.Lei on 2017/8/6.
 */
public class CommentListRequest extends AbstractAccessTokenRequest<CommentListResponse> {

    private long msgDataId;

    private int index;

    private int begin;

    private int count;

    private int type;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/comment/list?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg_data_id", msgDataId);
        jsonObject.put("index", index);
        jsonObject.put("begin", begin);
        jsonObject.put("count", count);
        jsonObject.put("type", type);
        return new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
    }

    public long getMsgDataId() {
        return msgDataId;
    }

    public void setMsgDataId(long msgDataId) {
        this.msgDataId = msgDataId;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
