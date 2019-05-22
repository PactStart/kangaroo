package io.github.pactstart.weixin.mp.request.kfmessage;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.DefaultJsonResponse;
import io.github.pactstart.weixin.mp.enums.KfMessageType;

/**
 * Created by Di.Lei on 2017/8/2.
 */
public class KfMusicMessage extends KfMessageRequest<DefaultJsonResponse> {

    private String musicUrl;

    private String hqMusicUrl;

    private String thumbMediaId;

    private String title;

    private String description;

    @Override
    public KfMessageType getMsgType() {
        return KfMessageType.music;
    }

    @Override
    public JSONObject getContent() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("musicurl", musicUrl);
        jsonObject.put("hqmusicurl", hqMusicUrl);
        jsonObject.put("thumb_media_id", thumbMediaId);
        jsonObject.put("title", title);
        jsonObject.put("description", description);
        return jsonObject;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getHqMusicUrl() {
        return hqMusicUrl;
    }

    public void setHqMusicUrl(String hqMusicUrl) {
        this.hqMusicUrl = hqMusicUrl;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
