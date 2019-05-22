package io.github.pactstart.weixin.mp.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Di.Lei on 2017/8/3.
 */
public class AutoReply {

    private boolean openAddFriendReply;

    @JSONField(name = "add_friend_autoreply_info")
    private Reply addFriendReplyInfo;

    private boolean openAutoReply;

    @JSONField(name = "message_default_autoreply_info")
    private Reply defaultAutoReplyInfo;

    private List<KeyWordReply> keyWordReplyInfoList;

    public boolean isOpenAddFriendReply() {
        return openAddFriendReply;
    }

    public void setOpenAddFriendReply(boolean openAddFriendReply) {
        this.openAddFriendReply = openAddFriendReply;
    }

    public Reply getAddFriendReplyInfo() {
        return addFriendReplyInfo;
    }

    public void setAddFriendReplyInfo(Reply addFriendReplyInfo) {
        this.addFriendReplyInfo = addFriendReplyInfo;
    }

    public boolean isOpenAutoReply() {
        return openAutoReply;
    }

    public void setOpenAutoReply(boolean openAutoReply) {
        this.openAutoReply = openAutoReply;
    }

    public Reply getDefaultAutoReplyInfo() {
        return defaultAutoReplyInfo;
    }

    public void setDefaultAutoReplyInfo(Reply defaultAutoReplyInfo) {
        this.defaultAutoReplyInfo = defaultAutoReplyInfo;
    }

    public List<KeyWordReply> getKeyWordReplyInfoList() {
        return keyWordReplyInfoList;
    }

    public void setKeyWordReplyInfoList(List<KeyWordReply> keyWordReplyInfoList) {
        this.keyWordReplyInfoList = keyWordReplyInfoList;
    }
}





