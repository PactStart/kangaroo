package io.github.pactstart.weixin.mp.response.masssend;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

/**
 * Created by Di.Lei on 2017/8/6.
 */
public class MassSendResponse extends JsonResponse {

    private String msgId;

    private String msgDataId;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.msgId = jsonObject.getString("msg_id");
        this.msgDataId = jsonObject.getString("msg_data_id");
    }

    public String getMsgId() {
        return msgId;
    }

    public String getMsgDataId() {
        return msgDataId;
    }
}
