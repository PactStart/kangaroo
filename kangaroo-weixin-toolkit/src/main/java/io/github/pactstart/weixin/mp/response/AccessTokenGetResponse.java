package io.github.pactstart.weixin.mp.response;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

/**
 * 获取公众号access_token响应
 * Created by Di.Lei on 2017/7/26.
 */
public class AccessTokenGetResponse extends JsonResponse {

    private String accessToken;

    private int expiresIn;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.accessToken = jsonObject.getString("access_token");
        this.expiresIn = jsonObject.getIntValue("expires_in");
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
