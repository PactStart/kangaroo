package io.github.pactstart.weixin.open.request.auth;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.request.Request;
import io.github.pactstart.weixin.open.response.auth.ComponentCreatePreAuthCodeResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

public class ComponentCreatePreAuthCodeRequest extends Request<ComponentCreatePreAuthCodeResponse> {

    private String componentAccessToken;

    private String componentAppId;

    @Override
    public HttpEntity getRequestEntity() {
        String data = "{\"component_appid\":\"" + componentAppId + "\" }";
        return new StringEntity(data, ContentType.APPLICATION_JSON);
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/component/api_create_preauthcode?component_access_token="
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
}
