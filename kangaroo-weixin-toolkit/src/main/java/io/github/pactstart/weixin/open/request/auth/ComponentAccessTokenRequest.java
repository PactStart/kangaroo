package io.github.pactstart.weixin.open.request.auth;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.request.Request;
import io.github.pactstart.weixin.open.response.auth.ComponentAccessTokenResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

public class ComponentAccessTokenRequest extends Request<ComponentAccessTokenResponse> {

    private String componentAppId;

    private String componentAppSecret;

    private String componentVerifyTicket;

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("component_appid", componentAppId);
        jsonObject.put("component_appsecret", componentAppSecret);
        jsonObject.put("component_verify_ticket", componentVerifyTicket);
        return new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/component/api_component_token";
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    public String getComponentAppId() {
        return componentAppId;
    }

    public void setComponentAppId(String componentAppId) {
        this.componentAppId = componentAppId;
    }

    public String getComponentAppSecret() {
        return componentAppSecret;
    }

    public void setComponentAppSecret(String componentAppSecret) {
        this.componentAppSecret = componentAppSecret;
    }

    public String getComponentVerifyTicket() {
        return componentVerifyTicket;
    }

    public void setComponentVerifyTicket(String componentVerifyTicket) {
        this.componentVerifyTicket = componentVerifyTicket;
    }
}
