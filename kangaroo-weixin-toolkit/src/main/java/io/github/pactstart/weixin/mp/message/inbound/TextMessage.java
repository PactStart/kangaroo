package io.github.pactstart.weixin.mp.message.inbound;

import org.dom4j.Element;

/**
 * Created by Rex.Lei on 2017/7/28.
 */
public class TextMessage extends AbstractReceivedMessage {

    private String content;

    @Override
    public void readMore(Element root) {
        this.content = root.elementText("Content");
    }

    public String getContent() {
        return content;
    }
}
