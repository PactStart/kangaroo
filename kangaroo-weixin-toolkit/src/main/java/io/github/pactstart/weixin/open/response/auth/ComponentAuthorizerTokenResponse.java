package io.github.pactstart.weixin.open.response.auth;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

public class ComponentAuthorizerTokenResponse extends JsonResponse {

    private String authorizerAccessToken;

    private int expiresIn;

    private String authorizerRefreshToken;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.authorizerAccessToken = jsonObject.getString("authorizer_access_token");
        this.expiresIn = jsonObject.getInteger("expires_in");
        this.authorizerRefreshToken = jsonObject.getString("authorizer_refresh_token");
    }

    public String getAuthorizerAccessToken() {
        return authorizerAccessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public String getAuthorizerRefreshToken() {
        return authorizerRefreshToken;
    }


}
