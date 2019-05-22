package io.github.pactstart.weixin.mp.message.outbound;

import org.dom4j.Element;

/**
 * Created by Di.Lei on 2017/8/1.
 */
public class ReplyMusicMessage extends AbstractReplyMessage {

    /**
     * 音乐标题
     */
    private String title;

    /**
     * 音乐描述
     */
    private String description;

    /**
     * 音乐链接
     */
    private String musicUrl;

    /**
     * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
     */
    private String hqMusicUrl;

    /**
     * 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
     */
    private String thumbMediaId;

    @Override
    protected void writeMore(Element root) {
        root.addElement("MsgType").addCDATA("music");
        Element musicEle = root.addElement("Music");
        musicEle.addElement("Title").addCDATA(title);
        musicEle.addElement("Description").addCDATA(description);
        musicEle.addElement("MusicUrl").addCDATA(musicUrl);
        musicEle.addElement("HQMusicUrl").addCDATA(hqMusicUrl);
        musicEle.addElement("ThumbMediaId").addCDATA(thumbMediaId);
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

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getHqMusicUrl() {
        return hqMusicUrl;
    }

    public void setHqMusicUrl(String hqMusicUrl) {
        this.hqMusicUrl = hqMusicUrl;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
