package io.github.pactstart.juhe.response;

import com.alibaba.fastjson.JSONObject;

public class JuheIdcardResponse extends JuheDefaultResponse {
    /*真实姓名*/
    private String realname;
    /*身份证号码*/
    private String idcard;
    /*1：匹配 2：不匹配*/
    private Integer res;

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
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
            idcard = result.getString("idcard");
            res = result.getInteger("res");
        }
    }
}
