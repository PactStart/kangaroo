package io.github.pactstart.weixin.open.response.auth;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

public class ComponentAccessTokenResponse extends JsonResponse {

    private String componentAccessToken;

    private int expiresIn;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.componentAccessToken = jsonObject.getString("component_access_token");
        this.expiresIn = jsonObject.getInteger("expires_in");
    }

    public String getComponentAccessToken() {
        return componentAccessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }


}
