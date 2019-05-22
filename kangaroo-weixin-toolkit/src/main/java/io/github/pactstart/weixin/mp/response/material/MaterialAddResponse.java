package io.github.pactstart.weixin.mp.response.material;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

/**
 * Created by Di.Lei on 2017/8/5.
 */
public class MaterialAddResponse extends JsonResponse {

    private String mediaId;

    /**
     * 新增的图片素材的图片URL（仅新增图片素材时会返回该字段）
     */
    private String url;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.mediaId = jsonObject.getString("media_id");
        this.url = jsonObject.getString("url");
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
