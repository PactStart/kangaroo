package io.github.pactstart.weixin.mp.request.comment;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.response.DefaultJsonResponse;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * Created by Di.Lei on 2017/8/6.
 */
public class CommentCloseRequest extends AbstractAccessTokenRequest<DefaultJsonResponse> {

    private long msgDataId;

    private int index;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/comment/close?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        String json = "{\"msg_data_id\":" + msgDataId + ",\"index\":" + index + "}";
        return new StringEntity(json, ContentType.APPLICATION_JSON);
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
}
