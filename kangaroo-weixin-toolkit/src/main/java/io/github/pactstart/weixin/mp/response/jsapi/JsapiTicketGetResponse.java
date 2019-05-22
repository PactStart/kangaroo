package io.github.pactstart.weixin.mp.response.jsapi;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class JsapiTicketGetResponse extends JsonResponse {

    private String ticket;

    private int expiresIn;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.ticket = jsonObject.getString("ticket");
        this.expiresIn = Integer.valueOf(jsonObject.getInteger("expires_in"));
    }

    public String getTicket() {
        return ticket;
    }

    public int getExpiresIn() {
        return expiresIn;
    }
}
