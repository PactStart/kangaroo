package io.github.pactstart.juhe.response;

import com.alibaba.fastjson.JSONObject;

public class JuheBankcardSilkResponse extends JuheDefaultResponse {
    /*银行归属*/
    private String bank;
    /*卡类型*/
    private String type;
    /*客服电话*/
    private String tel;
    /*银行logo，前面需加http://images.juheapi.com/banklogo/*/
    private String logo;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public void parseJSON(JSONObject jsonObject) {
        JSONObject result = jsonObject.getJSONObject("result");
        if (result != null) {
            bank = result.getString("bank");
            type = result.getString("type");
            tel = result.getString("tel");
            logo = result.getString("logo");
        }
    }
}
