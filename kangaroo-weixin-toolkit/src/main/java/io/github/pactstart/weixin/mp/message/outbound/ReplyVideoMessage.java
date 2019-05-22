package io.github.pactstart.weixin.mp.message.outbound;

import org.dom4j.Element;

/**
 * Created by Di.Lei on 2017/8/1.
 */
public class ReplyVideoMessage extends AbstractReplyMessage {

    /**
     * 通过素材管理中的接口上传多媒体文件，得到的id
     */
    private String mediaId;

    /**
     * 视频消息的标题
     */
    private String title;

    /**
     * 视频消息的描述
     */
    private String description;

    @Override
    protected void writeMore(Element root) {
        root.addElement("MsgType").addCDATA("video");
        Element videoElement = root.addElement("Video");
        videoElement.addElement("MediaId").addCDATA(mediaId);
        videoElement.addElement("Title").addCDATA(title);
        videoElement.addElement("Description").addCDATA(description);
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
