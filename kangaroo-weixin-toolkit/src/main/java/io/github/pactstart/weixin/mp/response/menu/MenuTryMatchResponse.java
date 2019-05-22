package io.github.pactstart.weixin.mp.response.menu;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;
import io.github.pactstart.weixin.mp.vo.Menu;

/**
 * Created by Rex.Lei on 2017/7/27.
 */
public class MenuTryMatchResponse extends JsonResponse {

    private Menu menu;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.menu = jsonObject.getObject("menu", Menu.class);
    }

    public Menu getMenu() {
        return menu;
    }
}
