package io.github.pactstart.weixin.mp.request;

import io.github.pactstart.weixin.common.request.Request;
import io.github.pactstart.weixin.common.response.Response;

/**
 * Created by Rex.Lei on 2017/7/27.
 */
public abstract class AbstractAccessTokenRequest<T extends Response> extends Request<T> {

    protected String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}