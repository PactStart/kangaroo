package io.github.pactstart.weixin.mp.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Di.Lei on 2017/8/5.
 */
public class NewsArticleExt extends NewsArticle {

    @JSONField(name = "thumb_url")
    private String thumbUrl;

    private String url;

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
