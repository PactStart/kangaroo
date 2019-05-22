package io.github.pactstart.weixin.mp.request.menu;

import com.alibaba.fastjson.JSON;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.menu.MenuCreateResponse;
import io.github.pactstart.weixin.mp.vo.Menu;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * Created by Rex.Lei on 2017/7/27.
 */
public class MenuCreateRequest extends AbstractAccessTokenRequest<MenuCreateResponse> {

    private Menu menu;

    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    public String getRequestPath() {
        return "/cgi-bin/menu/create?access_token=" + getAccessToken();
    }

    public HttpEntity getRequestEntity() {
        return new StringEntity(JSON.toJSONString(menu), ContentType.APPLICATION_JSON);
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
