package io.github.pactstart.weixin.mp.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by Di.Lei on 2017/8/2.
 */
public class KfAccount implements Serializable {

    /**
     * 完整客服账号，格式为：账号前缀@公众号微信号
     */
    @JSONField(name = "kf_account")
    private String kfAccount;

    /**
     * 客服昵称，最长6个汉字或12个英文字符
     */
    @JSONField(name = "kf_nick")
    private String kfNick;

    /**
     * 客服工号
     */
    @JSONField(name = "kf_id")
    private String kfId;

    /**
     * 客服头像
     */
    @JSONField(name = "kf_headimgurl")
    private String kfHeadImgUrl;

    public String getKfAccount() {
        return kfAccount;
    }

    public void setKfAccount(String kfAccount) {
        this.kfAccount = kfAccount;
    }

    public String getKfNick() {
        return kfNick;
    }

    public void setKfNick(String kfNick) {
        this.kfNick = kfNick;
    }

    public String getKfId() {
        return kfId;
    }

    public void setKfId(String kfId) {
        this.kfId = kfId;
    }

    public String getKfHeadImgUrl() {
        return kfHeadImgUrl;
    }

    public void setKfHeadImgUrl(String kfHeadImgUrl) {
        this.kfHeadImgUrl = kfHeadImgUrl;
    }
}
