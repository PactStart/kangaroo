package io.github.pactstart.weixin.mp.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Di.Lei on 2017/8/5.
 */
public class NewsContent {

    @JSONField(name = "news_item")
    private List<NewsArticleExt> articleList;

    @JSONField(name = "create_time")
    private Long createTime;

    @JSONField(name = "update_time")
    private Long updateTime;

    public List<NewsArticleExt> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<NewsArticleExt> articleList) {
        this.articleList = articleList;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
