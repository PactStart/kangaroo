package io.github.pactstart.weixin.mp.response.menu;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;
import io.github.pactstart.weixin.mp.vo.ConditionalMenu;
import io.github.pactstart.weixin.mp.vo.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rex.Lei on 2017/7/27.
 */
public class MenuGetResponse extends JsonResponse {

    private Menu menu;

    private List<ConditionalMenu> conditionalMenuList;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        menu = jsonObject.getJSONObject("menu").toJavaObject(Menu.class);
        JSONArray jsonArray = jsonObject.getJSONArray("conditionalmenu");
        if (jsonArray != null && jsonArray.size() > 0) {
            conditionalMenuList = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);
                conditionalMenuList.add(item.toJavaObject(ConditionalMenu.class));
            }
        }
    }

    public Menu getMenu() {
        return menu;
    }


    public List<ConditionalMenu> getConditionalMenuList() {
        return conditionalMenuList;
    }
}
