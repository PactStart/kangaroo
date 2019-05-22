package io.github.pactstart.juhe.response;

import com.alibaba.fastjson.JSONObject;

public class JuheVerifyBankCard4Response extends JuheDefaultResponse {
    /*本次查询流水号*/
    private String jobid;
    /*真实姓名*/
    private String realname;
    /*银行卡号码*/
    private String bankcard;
    /*身份证号码*/
    private String idcard;
    /*预留手机号码*/
    private String mobile;
    /*1：匹配 2：不匹配*/
    private Integer res;
    /*描述*/
    private String message;

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getRes() {
        return res;
    }

    public void setRes(Integer res) {
        this.res = res;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void parseJSON(JSONObject jsonObject) {
        JSONObject result = jsonObject.getJSONObject("result");
        if (result != null) {
            jobid = result.getString("jobid");
            realname = result.getString("realname");
            bankcard = result.getString("bankcard");
            idcard = result.getString("idcard");
            mobile = result.getString("mobile");
            res = result.getInteger("res");
            message = result.getString("message");
        }
    }
}
