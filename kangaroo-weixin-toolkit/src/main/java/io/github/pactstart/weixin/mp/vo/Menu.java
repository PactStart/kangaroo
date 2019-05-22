package io.github.pactstart.weixin.mp.vo;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.pactstart.weixin.common.WeixinAsserts;
import io.github.pactstart.weixin.common.config.SettingsManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rex.Lei on 2017/7/27.
 */
public class Menu implements Serializable {

    @JSONField(name = "menuid")
    private String menuId;

    @JSONField(name = "button")
    private List<MenuButton> buttonList;

    public Menu addButton(MenuButton button) {
        if (buttonList == null) {
            buttonList = new ArrayList<>();
        }
        int maxMenuSize = SettingsManager.getIntProperty("weixin.menu.maxSize", 3);
        WeixinAsserts.check(buttonList.size() >= maxMenuSize, "菜单个数不能超过%d个", maxMenuSize);
        buttonList.add(button);
        return this;
    }

    public List<MenuButton> getButtonList() {
        return buttonList;
    }

    public void setButtonList(List<MenuButton> buttonList) {
        this.buttonList = buttonList;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
