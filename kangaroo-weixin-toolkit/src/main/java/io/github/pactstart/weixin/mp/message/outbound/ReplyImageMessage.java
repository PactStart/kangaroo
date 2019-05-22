package io.github.pactstart.weixin.mp.message.outbound;

import org.dom4j.Element;

/**
 * Created by Di.Lei on 2017/8/1.
 */
public class ReplyImageMessage extends AbstractReplyMessage {

    /**
     * 通过素材管理中的接口上传多媒体文件，得到的id
     */
    private String mediaId;

    @Override
    protected void writeMore(Element root) {
        root.addElement("MsgType").addCDATA("image");
        root.addElement("Image").addElement("MediaId").addCDATA(mediaId);
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
