package io.github.pactstart.weixin.open.response.sns;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class ComponentSNSAccessTokenResponse extends JsonResponse {

    private String accessToken;

    private int expiresIn;

    private String refreshAccessToken;

    private String openid;

    private String scope;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.accessToken = jsonObject.getString("access_token");
        this.expiresIn = Integer.valueOf(jsonObject.getInteger("expires_in"));
        this.refreshAccessToken = jsonObject.getString("refresh_token");
        this.openid = jsonObject.getString("openid");
        this.scope = jsonObject.getString("scope");
    }

    public String getAccessToken() {
        return accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public String getRefreshAccessToken() {
        return refreshAccessToken;
    }

    public String getOpenid() {
        return openid;
    }

    public String getScope() {
        return scope;
    }
}
