package io.github.pactstart.juhe.request;

import io.github.pactstart.juhe.response.JuheVerifyBankCardResponse;

import java.util.HashMap;
import java.util.Map;

public class JuheVerifyBankCardRequest extends JuheDefaultRequest<JuheVerifyBankCardResponse> {
    private String bankcard;

    private String realname;

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public String getRequestPath() {
        return "/verifybankcard/query?key=" + getJuheProperties().getBankcardKey() + urlEncode(getParam());
    }

    public Map<String, Object> getParam() {
        Map<String, Object> param = new HashMap<>(3);
        param.put("bankcard", bankcard);
        param.put("realname", realname);
        return param;
    }
}
