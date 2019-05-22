package io.github.pactstart.weixin.mp.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 图文素材
 * Created by Di.Lei on 2017/8/5.
 */
public class NewsArticle {

    private String title;

    @JSONField(name = "thumb_media_id")
    private String thumbMediaId;

    private String author;

    private String digest;

    @JSONField(name = "show_cover_pic")
    private String showCoverPic;

    private String content;

    @JSONField(name = "content_source_url")
    private String contentSourceUrl;

    @JSONField(name = "need_open_comment")
    private int needOpenComment;

    @JSONField(name = "only_fans_can_comment")
    private int onlyFansCanComment;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getShowCoverPic() {
        return showCoverPic;
    }

    public void setShowCoverPic(String showCoverPic) {
        this.showCoverPic = showCoverPic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
    }

    public int getNeedOpenComment() {
        return needOpenComment;
    }

    public void setNeedOpenComment(int needOpenComment) {
        this.needOpenComment = needOpenComment;
    }

    public int getOnlyFansCanComment() {
        return onlyFansCanComment;
    }

    public void setOnlyFansCanComment(int onlyFansCanComment) {
        this.onlyFansCanComment = onlyFansCanComment;
    }
}
