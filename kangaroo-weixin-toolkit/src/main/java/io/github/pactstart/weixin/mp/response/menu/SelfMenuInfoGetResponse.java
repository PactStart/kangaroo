package io.github.pactstart.weixin.mp.response.menu;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;
import io.github.pactstart.weixin.mp.enums.MenuType;
import io.github.pactstart.weixin.mp.vo.Menu;
import io.github.pactstart.weixin.mp.vo.MenuButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rex.Lei on 2017/7/27.
 */
public class SelfMenuInfoGetResponse extends JsonResponse {

    private Menu menu;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        JSONObject menuNode = jsonObject.getJSONObject("selfmenu_info");

        //一级菜单列表
        JSONArray firstLevelMenuArr = menuNode.getJSONArray("button");
        if (firstLevelMenuArr != null && firstLevelMenuArr.size() > 0) {

            List<MenuButton> firstLevelButtonList = new ArrayList<>();

            for (int i = 0; i < firstLevelMenuArr.size(); i++) {
                MenuButton firstLevelButton = new MenuButton();
                //一级菜单
                JSONObject firstLevelMenu = firstLevelMenuArr.getJSONObject(i);
                firstLevelButton.setName(firstLevelMenu.getString("name"));
                String type = firstLevelMenu.getString("type");
                if (type != null) {
                    firstLevelButton.setType(MenuType.valueOf(type));
                }
                firstLevelButton.setKey(firstLevelMenu.getString("key"));
                firstLevelButton.setMediaId(firstLevelMenu.getString("media_id"));
                firstLevelButton.setUrl(firstLevelMenu.getString("url"));
                firstLevelButton.setAppid(firstLevelMenu.getString("appid"));
                firstLevelButton.setPagePath(firstLevelMenu.getString("page_path"));

                //二级菜单列表
                JSONArray secondLevelMenuArr = firstLevelMenu.getJSONObject("sub_button").getJSONArray("list");
                if (secondLevelMenuArr != null && secondLevelMenuArr.size() > 0) {
                    List<MenuButton> secondLevelButtonList = new ArrayList<>();
                    for (int j = 0; j < secondLevelMenuArr.size(); j++) {
                        //二级菜单
                        JSONObject secondLevelMenu = secondLevelMenuArr.getJSONObject(j);
                        secondLevelButtonList.add(secondLevelMenu.toJavaObject(MenuButton.class));
                    }
                    firstLevelButton.setSubButtonList(secondLevelButtonList);
                }

                firstLevelButtonList.add(firstLevelButton);
            }
            this.menu = new Menu();
            menu.setButtonList(firstLevelButtonList);
        }

    }

    public Menu getMenu() {
        return menu;
    }
}
