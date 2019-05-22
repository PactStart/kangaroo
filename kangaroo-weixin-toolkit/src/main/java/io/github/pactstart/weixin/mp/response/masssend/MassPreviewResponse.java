package io.github.pactstart.weixin.mp.response.masssend;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

/**
 * Created by Di.Lei on 2017/8/7.
 */
public class MassPreviewResponse extends JsonResponse {

    private String msgId;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.msgId = jsonObject.getString("msg_id");
    }

    public String getMsgId() {
        return msgId;
    }
}
