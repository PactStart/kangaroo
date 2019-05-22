package io.github.pactstart.weixin.mp.request.kfmessage;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.DefaultJsonResponse;
import io.github.pactstart.weixin.mp.enums.KfMessageType;

/**
 * Created by Di.Lei on 2017/8/2.
 */
public class KfMpNewsMessage extends KfMessageRequest<DefaultJsonResponse> {

    private String mediaId;

    @Override
    public KfMessageType getMsgType() {
        return KfMessageType.mpnews;
    }

    @Override
    public JSONObject getContent() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("media_id", mediaId);
        return jsonObject;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
