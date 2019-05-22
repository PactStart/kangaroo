package io.github.pactstart.juhe.request;

import io.github.pactstart.juhe.response.JuheBankcardSilkResponse;

import java.util.HashMap;
import java.util.Map;


public class JuheBankcardSilkRequest extends JuheDefaultRequest<JuheBankcardSilkResponse> {
    private String num;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String getRequestPath() {
        return "/bankcardsilk/query.php?key=" + getJuheProperties().getBankcardSilkKey() + urlEncode(getParam());
    }

    public Map<String, Object> getParam() {
        Map<String, Object> param = new HashMap<>(2);
        param.put("num", num);
        return param;
    }
}
