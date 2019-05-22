package io.github.pactstart.weixin.mp.response.account;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

/**
 * Created by Di.Lei on 2017/8/5.
 */
public class ShortUrlGenResponse extends JsonResponse {

    private String shortUrl;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.shortUrl = jsonObject.getString("short_url");
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
