package io.github.pactstart.weixin.open.request.auth;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.request.Request;
import io.github.pactstart.weixin.open.response.auth.ComponentAuthorizerTokenResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

public class ComponentAuthorizerTokenRequest extends Request<ComponentAuthorizerTokenResponse> {

    private String componentAccessToken;

    private String componentAppId;

    private String authorizerAppId;

    private String authorizerRefreshToken;

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("component_appid", componentAppId);
        jsonObject.put("authorizer_appid", authorizerAppId);
        jsonObject.put("authorizer_refresh_token", authorizerRefreshToken);
        return new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/component/api_authorizer_token?component_access_token="
                + componentAccessToken;
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    public String getComponentAccessToken() {
        return componentAccessToken;
    }

    public void setComponentAccessToken(String componentAccessToken) {
        this.componentAccessToken = componentAccessToken;
    }

    public String getComponentAppId() {
        return componentAppId;
    }

    public void setComponentAppId(String componentAppId) {
        this.componentAppId = componentAppId;
    }

    public String getAuthorizerAppId() {
        return authorizerAppId;
    }

    public void setAuthorizerAppId(String authorizerAppId) {
        this.authorizerAppId = authorizerAppId;
    }

    public String getAuthorizerRefreshToken() {
        return authorizerRefreshToken;
    }

    public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
        this.authorizerRefreshToken = authorizerRefreshToken;
    }
}
