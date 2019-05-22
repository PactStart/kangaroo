package io.github.pactstart.weixin.mp.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Di.Lei on 2017/8/6.
 */
public class Comment {

    @JSONField(name = "user_comment_id")
    private int userCommentId;

    private String openid;

    @JSONField(name = "create_time ")
    private Long createTime;

    private String content;

    @JSONField(name = "comment_type")
    private int commentType;

    private String replyContent;

    private Long replyCreateTime;

    private boolean isElected() {
        return commentType == 1;
    }

    public int getUserCommentId() {
        return userCommentId;
    }

    public void setUserCommentId(int userCommentId) {
        this.userCommentId = userCommentId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommentType() {
        return commentType;
    }

    public void setCommentType(int commentType) {
        this.commentType = commentType;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Long getReplyCreateTime() {
        return replyCreateTime;
    }

    public void setReplyCreateTime(Long replyCreateTime) {
        this.replyCreateTime = replyCreateTime;
    }
}
