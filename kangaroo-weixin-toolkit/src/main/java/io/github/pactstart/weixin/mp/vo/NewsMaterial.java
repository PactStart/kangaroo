package io.github.pactstart.weixin.mp.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Di.Lei on 2017/8/5.
 */
public class NewsMaterial {

    @JSONField(name = "media_id")
    private String mediaId;

    @JSONField(name = "content")
    private NewsContent content;

    @JSONField(name = "update_time")
    private Long updateTime;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public NewsContent getContent() {
        return content;
    }

    public void setContent(NewsContent content) {
        this.content = content;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
