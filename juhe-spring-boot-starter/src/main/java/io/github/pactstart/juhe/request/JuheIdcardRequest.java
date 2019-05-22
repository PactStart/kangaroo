package io.github.pactstart.juhe.request;

import io.github.pactstart.juhe.response.JuheIdcardResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * 姓名身份证验证请求
 */
public class JuheIdcardRequest extends JuheDefaultRequest<JuheIdcardResponse> {

    private String idcard;

    private String realname;

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public String getRequestPath() {
        return "/idcard/query?key=" + getJuheProperties().getIdcardKey() + urlEncode(getParam());
    }

    public Map<String, Object> getParam() {
        Map<String, Object> param = new HashMap<>(3);
        param.put("idcard", idcard);
        param.put("realname", realname);
        return param;
    }
}
