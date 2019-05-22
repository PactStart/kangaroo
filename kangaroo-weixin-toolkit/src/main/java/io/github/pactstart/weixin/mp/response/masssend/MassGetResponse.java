package io.github.pactstart.weixin.mp.response.masssend;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

/**
 * Created by Di.Lei on 2017/8/7.
 */
public class MassGetResponse extends JsonResponse {

    private Long msgId;

    private String msgStatus;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.msgId = jsonObject.getLong("msg_id");
        this.msgStatus = jsonObject.getString("msg_status");
    }

    public Long getMsgId() {
        return msgId;
    }

    public String getMsgStatus() {
        return msgStatus;
    }
}
