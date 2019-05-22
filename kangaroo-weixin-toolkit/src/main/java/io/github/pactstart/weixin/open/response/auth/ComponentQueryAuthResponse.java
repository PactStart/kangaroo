package io.github.pactstart.weixin.open.response.auth;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

import java.util.Arrays;

public class ComponentQueryAuthResponse extends JsonResponse {

    private String authorizerAppId;

    private String authorizerAccessToken;

    private String authorizerRefreshToken;

    private int[] funcIds;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        JSONObject node = jsonObject.getJSONObject("authorization_info");
        this.authorizerAppId = node.getString("authorizer_appid");
        this.authorizerAccessToken = node.getString("authorizer_access_token");
        this.authorizerRefreshToken = node.getString("authorizer_refresh_token");
        JSONArray funcNode = node.getJSONArray("func_info");
        funcIds = new int[funcNode.size()];
        for (int i = 0; i < funcNode.size(); i++) {
            int funcId = funcNode.getJSONObject(i).getJSONObject("funcscope_category").getInteger("id");
            funcIds[i] = funcId;
        }
        Arrays.sort(funcIds);
    }

    public String getAuthorizerAppId() {
        return authorizerAppId;
    }

    public String getAuthorizerAccessToken() {
        return authorizerAccessToken;
    }

    public String getAuthorizerRefreshToken() {
        return authorizerRefreshToken;
    }

    public int[] getFuncIds() {
        return funcIds;
    }

}
