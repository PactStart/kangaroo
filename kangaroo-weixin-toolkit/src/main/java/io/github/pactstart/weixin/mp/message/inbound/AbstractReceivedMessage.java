package io.github.pactstart.weixin.mp.message.inbound;

import org.dom4j.Element;

/**
 * Created by Rex.Lei on 2017/7/28.
 */
public abstract class AbstractReceivedMessage extends InboundXmlMessage {

    protected String msgId;
    private String toUserName;
    private String fromUserName;
    private long createTime;
    private String msgType;
    private String event;

    private boolean isEvent;

    @Override
    public void read(Element root) {
        this.toUserName = root.elementText("ToUserName");
        this.fromUserName = root.elementText("FromUserName");
        this.createTime = Long.parseLong(root.elementText("CreateTime"));
        this.msgType = root.elementText("MsgType");
        boolean isEvent = "event".equals(this.msgType);
        if (isEvent) {
            this.event = root.elementText("Event");
        } else {
            this.msgId = root.elementText("MsgId");
        }
        this.readMore(root);
    }

    protected abstract void readMore(Element root);

    public String getToUserName() {
        return toUserName;
    }


    public String getFromUserName() {
        return fromUserName;
    }


    public long getCreateTime() {
        return createTime;
    }


    public String getMsgType() {
        return msgType;
    }


    public String getMsgId() {
        return msgId;
    }

    public String getEvent() {
        return event;
    }

    public boolean isEvent() {
        return isEvent;
    }
}
