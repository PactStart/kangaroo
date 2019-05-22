package io.github.pactstart.weixin.mp.vo;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class OpenId {

    private String openid;

    private String lang = "zh_CN";

    public OpenId(String openid) {
        this.openid = openid;
    }

    public OpenId(String openid, String lang) {
        this.openid = openid;
        this.lang = lang;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
