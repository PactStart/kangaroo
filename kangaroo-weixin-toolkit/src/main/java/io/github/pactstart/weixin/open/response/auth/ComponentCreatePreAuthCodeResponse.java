package io.github.pactstart.weixin.open.response.auth;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

public class ComponentCreatePreAuthCodeResponse extends JsonResponse {

    private String preAuthCode;

    private int expiresIn; //有效期，单位秒

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.preAuthCode = jsonObject.getString("pre_auth_code");
        this.expiresIn = jsonObject.getInteger("expires_in");
    }

    public String getPreAuthCode() {
        return preAuthCode;
    }

    public int getExpiresIn() {
        return expiresIn;
    }


}
