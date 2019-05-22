package io.github.pactstart.weixin.mp.message.inbound.event;

import io.github.pactstart.weixin.mp.message.inbound.AbstractReceivedMessage;
import org.dom4j.Element;

/**
 * 点击菜单拉取消息时的事件推送
 * Created by Di.Lei on 2017/8/1.
 */
public class ClickMenuEvent extends AbstractReceivedMessage {

    /**
     * 与自定义菜单接口中KEY值对应
     */
    private String eventKey;

    @Override
    public void readMore(Element root) {
        this.eventKey = root.elementText("EventKey");
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
