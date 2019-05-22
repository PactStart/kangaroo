package io.github.pactstart.weixin.mp.message.inbound.event;

import io.github.pactstart.weixin.mp.message.inbound.AbstractReceivedMessage;
import org.dom4j.Element;

public class PicEvent extends AbstractReceivedMessage {

    private String eventKey;

    private String count;

    private String picList;

    @Override
    protected void readMore(Element root) {
        this.eventKey = root.elementText("EventKey");
        Element sendPicsInfoElement = root.element("SendPicsInfo");
        this.count = sendPicsInfoElement.elementText("Count");
        this.picList = sendPicsInfoElement.elementText("PicList");
    }

    public String getEventKey() {
        return eventKey;
    }

    public String getCount() {
        return count;
    }

    public String getPicList() {
        return picList;
    }
}
