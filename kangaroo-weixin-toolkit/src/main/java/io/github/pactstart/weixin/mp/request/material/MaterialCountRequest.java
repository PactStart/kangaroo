package io.github.pactstart.weixin.mp.request.material;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.material.MaterialCountResponse;
import org.apache.http.HttpEntity;

/**
 * Created by Di.Lei on 2017/8/5.
 */
public class MaterialCountRequest extends AbstractAccessTokenRequest<MaterialCountResponse> {
    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/material/get_materialcount?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }
}
