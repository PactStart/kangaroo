package io.github.pactstart.weixin.open.request.sns;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.request.Request;
import io.github.pactstart.weixin.open.response.sns.ComponentSNSAccessTokenResponse;
import org.apache.http.HttpEntity;

/**
 * 开放平台代发起网页授权时，通过code换取网页授权access_token
 * Created by Di.Lei on 2017/8/12.
 */
public class ComponentSNSAccessTokenGetRequest extends Request<ComponentSNSAccessTokenResponse> {

    private String appid;

    private String secret;

    private String code;

    private String componentAppid;

    private String componentAccessToken;

    public ComponentSNSAccessTokenGetRequest(String appid, String secret, String code, String componentAppid, String componentAccessToken) {
        this.appid = appid;
        this.secret = secret;
        this.code = code;
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
        sb.append("/sns/oauth2/component/access_token?appid=").append(appid)
                .append("&secret=").append(secret)
                .append("&code=").append(code)
                .append("&grant_type=authorization_code")
                .append("&component_appid=").append(componentAppid)
                .append("&component_access_token=").append(componentAccessToken);
        return sb.toString();
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }
}
