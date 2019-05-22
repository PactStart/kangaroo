package io.github.pactstart.weixin.mp.vo;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.pactstart.weixin.common.WeixinAsserts;
import io.github.pactstart.weixin.common.config.SettingsManager;
import io.github.pactstart.weixin.mp.enums.MenuType;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rex.Lei on 2017/7/27.
 */
public class MenuButton implements Serializable {

    private MenuType type;

    private String name;

    private String key;

    private String url;

    @JSONField(name = "media_id")
    private String mediaId;

    private String appid;


    @JSONField(name = "page_path")
    private String pagePath;

    @JSONField(name = "sub_button")
    private List<MenuButton> subButtonList;

    public MenuButton() {
    }

    public MenuButton(MenuType type, String name, String key, String url, String mediaId, String appid, String pagePath) {
        WeixinAsserts.notEmpty(name, "菜单标题不能为空");
        int maxMenuNameByteLength = SettingsManager.getIntProperty("weixin.menu.name.maxByteLength", 16);
        WeixinAsserts.check(name.getBytes().length > maxMenuNameByteLength, "菜单标题:%s超过%d个字节", name, maxMenuNameByteLength);
        if (StringUtils.isNotEmpty(key)) {
            int maxMenuKeyByteLength = SettingsManager.getIntProperty("weixin.menu.key.maxByteLength", 128);
            WeixinAsserts.check(key.getBytes().length > maxMenuKeyByteLength, "菜单key:%s超过%d个字节", key, maxMenuKeyByteLength);
        }
        if (StringUtils.isNotEmpty(url)) {
            int maxMenuUrlByteLength = SettingsManager.getIntProperty("weixin.menu.url.maxByteLength", 1024);
            WeixinAsserts.check(url.getBytes().length > maxMenuUrlByteLength, "菜单url:%s超过%d个字节", url, maxMenuUrlByteLength);
        }
        this.type = type;
        this.name = name;
        this.key = key;
        this.url = url;
        this.mediaId = mediaId;
        this.appid = appid;
        this.pagePath = pagePath;
    }

    public static MenuButton newParentMenu(String name) {
        return new MenuButton(null, name, null, null, null, null, null);
    }

    /**
     * 小程序按钮
     *
     * @param name
     * @param url
     * @param appid
     * @param pagePath
     * @return
     */
    public static MenuButton newMiniProgram(String name, String url, String appid, String pagePath) {
        return new MenuButton(MenuType.miniprogram, name, null, url, null, appid, pagePath);
    }

    /**
     * 图片按钮
     *
     * @param name
     * @param mediaId
     * @return
     */
    public static MenuButton newMediaId(String name, String mediaId) {
        return new MenuButton(MenuType.media_id, name, null, null, mediaId, null, null);
    }

    /**
     * 图文消息按钮
     *
     * @param name
     * @param mediaId
     * @return
     */
    public static MenuButton newViewLimited(String name, String mediaId) {
        return new MenuButton(MenuType.view_limited, name, null, null, mediaId, null, null);
    }

    /**
     * 视图页面按钮
     *
     * @param name
     * @param url
     * @return
     */
    public static MenuButton newView(String name, String url) {
        return new MenuButton(MenuType.view, name, null, url, null, null, null);
    }

    /**
     * 点击按钮
     *
     * @param type
     * @param name
     * @param key
     * @return
     */
    public static MenuButton newLikeClick(MenuType type, String name, String key) {
        return new MenuButton(type, name, key, null, null, null, null);
    }

    public MenuButton addSubMenu(MenuButton subButton) {
        if (subButtonList == null) {
            subButtonList = new ArrayList<MenuButton>();
        }
        WeixinAsserts.notNull(subButton.getType(), "未指定子菜单类型");

        int maxSubMenuSize = SettingsManager.getIntProperty("weixin.subMenu.maxSize", 5);
        WeixinAsserts.check(subButtonList.size() >= maxSubMenuSize, "子菜单个数不能超过%d个", maxSubMenuSize);

        int maxSubMenuNameByteLength = SettingsManager.getIntProperty("weixin.subMenu.name.maxByteLength", 60);
        WeixinAsserts.check(subButton.getName().getBytes().length > maxSubMenuNameByteLength, "子菜单标题不能超过%d个字节", maxSubMenuNameByteLength);
        subButtonList.add(subButton);
        return this;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public List<MenuButton> getSubButtonList() {
        return subButtonList;
    }

    public void setSubButtonList(List<MenuButton> subButtonList) {
        this.subButtonList = subButtonList;
    }
}
