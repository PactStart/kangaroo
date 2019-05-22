package io.github.pactstart.weixin.mp.message.outbound;

import org.dom4j.Element;

/**
 * Created by Rex.Lei on 2017/7/28.
 */
public abstract class AbstractReplyMessage extends OutboundXmlMessage {

    private String toUserName;

    private String fromUserName;

    private long createTime = System.currentTimeMillis() / 1000;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    protected void write(Element root) {
        root.addElement("ToUserName").addCDATA(toUserName);
        root.addElement("FromUserName").addCDATA(fromUserName);
        root.addElement("CreateTime").setText(String.valueOf(createTime));
        this.writeMore(root);
    }

    protected abstract void writeMore(Element root);
}
