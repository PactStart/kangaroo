package io.github.pactstart.weixin.mp.request.menu;

import com.alibaba.fastjson.JSON;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.menu.ConditionalMenuCreateResponse;
import io.github.pactstart.weixin.mp.vo.ConditionalMenu;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * Created by Rex.Lei on 2017/7/27.
 */
public class ConditionalMenuCreateRequest extends AbstractAccessTokenRequest<ConditionalMenuCreateResponse> {

    private ConditionalMenu menu;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/menu/addconditional?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        return new StringEntity(JSON.toJSONString(menu), ContentType.APPLICATION_JSON);
    }

    public ConditionalMenu getMenu() {
        return menu;
    }

    public void setMenu(ConditionalMenu menu) {
        this.menu = menu;
    }
}
