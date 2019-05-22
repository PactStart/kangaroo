package io.github.pactstart.weixin.mp.message.inbound;

import org.dom4j.Element;

/**
 * Created by Rex.Lei on 2017/7/28.
 */
public class ImageMessage extends AbstractReceivedMessage {

    private String picUrl;

    private String mediaId;

    @Override
    public void readMore(Element root) {
        this.picUrl = root.elementText("PicUrl");
        this.mediaId = root.elementText("MediaId");
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }
}
