package io.github.pactstart.weixin.mp.message.inbound;

import org.dom4j.Element;

/**
 * Created by Rex.Lei on 2017/7/28.
 */
public class VideoMessage extends AbstractReceivedMessage {

    private String mediaId;

    private String thumbMediaId;

    @Override
    public void readMore(Element root) {
        this.mediaId = root.elementText("MediaId");
        this.thumbMediaId = root.elementText("ThumbMediaId");
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }
}
