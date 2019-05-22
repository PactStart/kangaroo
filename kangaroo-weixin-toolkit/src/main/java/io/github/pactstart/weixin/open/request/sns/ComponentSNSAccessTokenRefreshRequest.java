package io.github.pactstart.weixin.open.request.sns;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.request.Request;
import io.github.pactstart.weixin.open.response.sns.ComponentSNSAccessTokenResponse;
import org.apache.http.HttpEntity;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class ComponentSNSAccessTokenRefreshRequest extends Request<ComponentSNSAccessTokenResponse> {

    private String appid;

    private String refreshToken;

    private String componentAppid;

    private String componentAccessToken;

    public ComponentSNSAccessTokenRefreshRequest(String appid, String refreshToken, String componentAppid, String componentAccessToken) {
        this.appid = appid;
        this.refreshToken = refreshToken;
        this.componentAppid = componentAppid;
        this.componentAccessToken = componentAccessToken;
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getRequestPath() {
        StringBuilder sb = new StringBuilder();
        sb.append("/sns/oauth2/component/refresh_token?appid=").append(appid)
                .append("&grant_type=refresh_token")
                .append("&component_appid=").append(componentAppid)
                .append("&component_access_token=").append(componentAccessToken)
                .append("&refresh_token=").append(refreshToken);
        return sb.toString();
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }
}
