package io.github.pactstart.weixin.mp.request.masssend;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.masssend.MassGetResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * Created by Di.Lei on 2017/8/7.
 */
public class MassGetRequest extends AbstractAccessTokenRequest<MassGetResponse> {

    private String msgId;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/message/mass/get?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        return new StringEntity("{\"msg_id\":\"" + msgId + "\"}", ContentType.APPLICATION_JSON);
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
