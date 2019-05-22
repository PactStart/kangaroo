package io.github.pactstart.weixin.mp.message.outbound;

import org.dom4j.Element;

/**
 * Created by Di.Lei on 2017/8/1.
 */
public class ReplyVoiceMessage extends AbstractReplyMessage {

    private String mediaId;

    @Override
    protected void writeMore(Element root) {
        root.addElement("MsgType").addCDATA("voice");
        root.addElement("Voice").addElement("MediaId").addCDATA(mediaId);
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
