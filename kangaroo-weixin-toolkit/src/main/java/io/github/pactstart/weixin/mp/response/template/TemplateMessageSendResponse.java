package io.github.pactstart.weixin.mp.response.template;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

/**
 * Created by Di.Lei on 2017/8/2.
 */
public class TemplateMessageSendResponse extends JsonResponse {

    private String msgId;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.msgId = jsonObject.getString("msgid");
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
