package io.github.pactstart.weixin.mp.request.kfmessage;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.DefaultJsonResponse;
import io.github.pactstart.weixin.mp.enums.KfMessageType;

/**
 * Created by Di.Lei on 2017/8/2.
 */
public class KfTextMessage extends KfMessageRequest<DefaultJsonResponse> {

    private String text;

    @Override
    public KfMessageType getMsgType() {
        return KfMessageType.text;
    }

    @Override
    public JSONObject getContent() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", text);
        return jsonObject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
