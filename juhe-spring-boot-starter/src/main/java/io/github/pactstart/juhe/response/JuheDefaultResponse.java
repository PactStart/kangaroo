package io.github.pactstart.juhe.response;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.http.Response;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public abstract class JuheDefaultResponse extends Response {
    private static Logger logger = LoggerFactory.getLogger(JuheDefaultResponse.class);

    @Override
    public void process(HttpEntity entity) throws IOException {
        String result = EntityUtils.toString(entity, "utf-8");
        if (logger.isDebugEnabled()) {
            logger.debug("响应结果>>>{}", result);
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (jsonObject.containsKey("error_code")) {
            this.errcode = jsonObject.getIntValue("error_code");
        }

        if (jsonObject.containsKey("reason")) {
            this.errmsg = jsonObject.getString("reason");
        }

        if (isOk()) {
            this.parseJSON(jsonObject);
        }

        EntityUtils.consumeQuietly(entity);
    }

    public abstract void parseJSON(JSONObject jsonObject);
}
