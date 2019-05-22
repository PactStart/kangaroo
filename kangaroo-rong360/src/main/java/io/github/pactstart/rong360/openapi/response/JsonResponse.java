package io.github.pactstart.rong360.openapi.response;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

@Slf4j
@Getter
@Setter
public class JsonResponse implements BaseResponse {

    private int error;

    private String msg;

    @Override
    public void process(HttpResponse response) throws Exception {
        String result = EntityUtils.toString(response.getEntity());
        if (log.isDebugEnabled()) {
            log.debug(result);
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        this.error = jsonObject.getInteger("error");
        this.msg = jsonObject.getString("msg");
        parseJSON(jsonObject);
    }

    /**
     * 模板方法 供子类覆盖
     *
     * @param jsonObject json对象
     */
    public void parseJSON(JSONObject jsonObject) {

    }

    /**
     * 请求是否成功，这里指的是业务成功，能拿到响应通信肯定是成功的
     *
     * @return
     */
    public boolean isSuccess() {
        return this.error == 200;
    }
}
