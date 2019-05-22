package io.github.pactstart.juhe.request;

import io.github.pactstart.juhe.response.JuheVerifyBankCard4Response;

import java.util.HashMap;
import java.util.Map;

public class JuheVerifyBankCard4Request extends JuheDefaultRequest<JuheVerifyBankCard4Response> {
    private String realname;

    private String idcard;

    private String bankcard;

    private String mobile;

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

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String getRequestPath() {
        return "/verifybankcard4/query.php?key=" + getJuheProperties().getBankcard4Key() + urlEncode(getParam());
    }

    public Map<String, Object> getParam() {
        Map<String, Object> param = new HashMap<>(3);
        param.put("realname", realname);
        param.put("idcard", idcard);
        param.put("bankcard", bankcard);
        param.put("mobile", mobile);
        return param;
    }
}
