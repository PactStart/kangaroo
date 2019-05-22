package io.github.pactstart.weixin.mp.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class KeyWordReply {

    @JSONField(name = "rule_name")
    private String ruleName;

    @JSONField(name = "create_time")
    private Long createTime;

    @JSONField(name = "reply_mode")
    private String replyMode;

    @JSONField(name = "keyword_list_info")
    private List<KeyWord> keywordList;

    @JSONField(name = "reply_list_info")
    private List<Reply> replyList;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getReplyMode() {
        return replyMode;
    }

    public void setReplyMode(String replyMode) {
        this.replyMode = replyMode;
    }

    public List<KeyWord> getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(List<KeyWord> keywordList) {
        this.keywordList = keywordList;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }
}