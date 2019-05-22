package io.github.pactstart.weixin.mp.response.material;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

/**
 * Created by Di.Lei on 2017/8/5.
 */
public class MaterialCountResponse extends JsonResponse {

    private int voiceCount;

    private int videoCount;

    private int imageCount;

    private int newsCount;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.voiceCount = jsonObject.getInteger("voice_count");
        this.videoCount = jsonObject.getInteger("video_count");
        this.imageCount = jsonObject.getInteger("image_count");
        this.newsCount = jsonObject.getInteger("news_count");
    }

    public int getVoiceCount() {
        return voiceCount;
    }

    public void setVoiceCount(int voiceCount) {
        this.voiceCount = voiceCount;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

    public int getImageCount() {
        return imageCount;
    }

    public void setImageCount(int imageCount) {
        this.imageCount = imageCount;
    }

    public int getNewsCount() {
        return newsCount;
    }

    public void setNewsCount(int newsCount) {
        this.newsCount = newsCount;
    }
}
