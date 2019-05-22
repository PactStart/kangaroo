package io.github.pactstart.weixin.mp.request.menu;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.menu.MenuDeleteResponse;
import org.apache.http.HttpEntity;

/**
 * Created by Rex.Lei on 2017/7/27.
 */
public class MenuDeleteRequest extends AbstractAccessTokenRequest<MenuDeleteResponse> {
    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/menu/delete?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }
}
