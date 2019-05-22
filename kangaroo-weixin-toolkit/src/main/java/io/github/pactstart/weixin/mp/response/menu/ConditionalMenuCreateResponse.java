package io.github.pactstart.weixin.mp.response.menu;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

/**
 * Created by Rex.Lei on 2017/7/27.
 */
public class ConditionalMenuCreateResponse extends JsonResponse {

    private String menuId;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.menuId = jsonObject.getString("menuid");
    }
}
