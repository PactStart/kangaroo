package io.github.pactstart.weixin.mp.message.inbound.event;

import io.github.pactstart.weixin.mp.message.inbound.AbstractReceivedMessage;
import org.dom4j.Element;

/**
 * 点击菜单跳转链接时的事件推送
 * Created by Di.Lei on 2017/8/1.
 */
public class ViewMenuEvent extends AbstractReceivedMessage {

    /**
     * 设置的跳转URL
     */
    private String url;

    /**
     * 指菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了。
     */
    private String menuId;

    @Override
    public void readMore(Element root) {
        this.url = root.elementText("EventKey");
        this.menuId = root.elementText("MenuId");
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
