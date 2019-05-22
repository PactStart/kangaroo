package io.github.pactstart.weixin.mp.message.outbound;

import org.dom4j.Element;

/**
 * Created by Rex.Lei on 2017/7/28.
 */
public class ReplyTextMessage extends AbstractReplyMessage {

    private String content;

    public ReplyTextMessage(String content) {
        this.content = content;
    }

    @Override
    protected void writeMore(Element root) {
        root.addElement("MsgType").addCDATA("text");
        root.addElement("Content").addCDATA(content);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
