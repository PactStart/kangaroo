package io.github.pactstart.weixin.common.response;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Di.Lei on 2017/7/26.
 */
public abstract class JsonResponse extends Response {

    private static Logger logger = LoggerFactory.getLogger(JsonResponse.class);

    @Override
    public void process(HttpEntity entity, Header[] headers) throws Exception {
        String result = EntityUtils.toString(entity, "utf-8");
        if (logger.isDebugEnabled()) {
            logger.debug("响应结果>>>{}", result);
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (jsonObject.containsKey("errcode")) {
            this.errcode = jsonObject.getIntValue("errcode");
            this.errmsg = jsonObject.getString("errmsg");
        }
        if (isOk()) {
            this.parseJSON(jsonObject);
        }
        EntityUtils.consumeQuietly(entity);
    }

    public abstract void parseJSON(JSONObject jsonObject);


}
