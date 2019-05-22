package io.github.pactstart.weixin.common;

/**
 * Created by Di.Lei on 2017/7/26.
 */
public class WeixinBizStatus {

    private int errcode;

    private String errmsg;

    public WeixinBizStatus(int errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
