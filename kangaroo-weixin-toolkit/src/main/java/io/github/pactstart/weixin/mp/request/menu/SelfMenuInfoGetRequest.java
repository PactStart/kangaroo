package io.github.pactstart.weixin.mp.request.menu;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.menu.SelfMenuInfoGetResponse;
import org.apache.http.HttpEntity;


/**
 * 获取自定义菜单的配置，
 * 如果公众号是通过API调用设置的菜单，则返回菜单的开发配置，
 * 而如果公众号是在公众平台官网通过网站功能发布菜单，则返回运营者设置的菜单配置。
 * Created by Rex.Lei on 2017/7/27.
 */
public class SelfMenuInfoGetRequest extends AbstractAccessTokenRequest<SelfMenuInfoGetResponse> {
    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/get_current_selfmenu_info?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }
}
