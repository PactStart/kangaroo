package io.github.pactstart.juhe.response;

import com.alibaba.fastjson.JSONObject;

public class JuheVerifyBankCardResponse extends JuheDefaultResponse {

    /*真实姓名*/
    private String realname;
    /*银行卡号码*/
    private String bankcard;
    /*1：匹配 2：不匹配*/
    private Integer res;

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

    public Integer getRes() {
        return res;
    }

    public void setRes(Integer res) {
        this.res = res;
    }

    @Override
    public void parseJSON(JSONObject jsonObject) {
        JSONObject result = jsonObject.getJSONObject("result");
        if (result != null) {
            realname = result.getString("realname");
            bankcard = result.getString("bankcard");
            res = result.getInteger("res");
        }
    }
}
