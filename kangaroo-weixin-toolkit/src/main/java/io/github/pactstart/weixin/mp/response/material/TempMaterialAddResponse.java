package io.github.pactstart.weixin.mp.response.material;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

/**
 * Created by Di.Lei on 2017/8/4.
 */
public class TempMaterialAddResponse extends JsonResponse {

    private String mediaId;

    private Long createAt;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.mediaId = jsonObject.getString("media_id");
        this.createAt = jsonObject.getLong("created_at");
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }
}
