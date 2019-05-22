package io.github.pactstart.weixin.mp.message.inbound;

import org.dom4j.Element;

/**
 * Created by Rex.Lei on 2017/7/28.
 */
public class VoiceMessage extends AbstractReceivedMessage {

    private String mediaId;

    private String format; //一般为amr

    private String recognition; //语音识别结果，使用UTF8编码

    @Override
    public void readMore(Element root) {
        this.mediaId = root.elementText("MediaId");
        this.format = root.elementText("Format");
        if (root.element("Recognition") != null) {
            this.recognition = root.elementText("Recognition");
        }
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getFormat() {
        return format;
    }

    public String getRecognition() {
        return recognition;
    }
}
