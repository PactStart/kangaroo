package io.github.pactstart.weixin.mp.response.account;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

/**
 * Created by Di.Lei on 2017/8/5.
 */
public class SceneQrCodeCreateResponse extends JsonResponse {

    private String ticket;

    /**
     * 只有临时二维码才不为null
     */
    private Integer expireSeconds;

    private String url;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.ticket = jsonObject.getString("ticket");
        this.url = jsonObject.getString("url");
        String expireSec = jsonObject.getString("expire_seconds");
        if (expireSec != null) {
            this.expireSeconds = Integer.valueOf(expireSec);
        }
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(Integer expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
