package io.github.pactstart.weixin.mp.response.material;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

/**
 * Created by Di.Lei on 2017/8/5.
 */
public class NewsMaterialAddResponse extends JsonResponse {

    private String mediaId;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.mediaId = jsonObject.getString("media_id");
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
