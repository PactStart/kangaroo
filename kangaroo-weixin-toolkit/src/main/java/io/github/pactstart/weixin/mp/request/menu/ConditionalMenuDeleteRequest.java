package io.github.pactstart.weixin.mp.request.menu;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.menu.ConditionalMenuDeleteResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * Created by Rex.Lei on 2017/7/27.
 */
public class ConditionalMenuDeleteRequest extends AbstractAccessTokenRequest<ConditionalMenuDeleteResponse> {

    private String menuId;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/menu/delconditional?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("menuid", menuId);
        return new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
