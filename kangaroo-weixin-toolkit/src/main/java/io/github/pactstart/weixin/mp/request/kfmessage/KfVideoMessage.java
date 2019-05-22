package io.github.pactstart.weixin.mp.request.kfmessage;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.DefaultJsonResponse;
import io.github.pactstart.weixin.mp.enums.KfMessageType;

/**
 * Created by Di.Lei on 2017/8/2.
 */
public class KfVideoMessage extends KfMessageRequest<DefaultJsonResponse> {

    private String mediaId;

    private String thumbMediaId;

    private String title;

    private String description;


    @Override
    public KfMessageType getMsgType() {
        return KfMessageType.video;
    }

    @Override
    public JSONObject getContent() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("media_id", mediaId);
        jsonObject.put("thumb_media_id", thumbMediaId);
        jsonObject.put("title", title);
        jsonObject.put("description", description);
        return jsonObject;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
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
