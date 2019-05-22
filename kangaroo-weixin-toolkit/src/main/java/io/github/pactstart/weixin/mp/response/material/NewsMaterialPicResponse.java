package io.github.pactstart.weixin.mp.response.material;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

/**
 * Created by Di.Lei on 2017/8/4.
 */
public class NewsMaterialPicResponse extends JsonResponse {

    private String url;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.url = jsonObject.getString("url");
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
