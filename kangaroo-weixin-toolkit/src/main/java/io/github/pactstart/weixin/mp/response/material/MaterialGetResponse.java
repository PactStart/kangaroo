package io.github.pactstart.weixin.mp.response.material;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.MiscResponse;
import io.github.pactstart.weixin.mp.vo.NewsContent;
import io.github.pactstart.weixin.mp.vo.Video;

/**
 * Created by Di.Lei on 2017/8/5.
 */
public class MaterialGetResponse extends MiscResponse {

    /**
     * 如果请求的media_id是图文素材，则返回图文内容
     */
    private NewsContent news;

    /**
     * 如果请求的media_id是视频素材，则返回视频信息
     */
    private Video video;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        if (jsonObject.containsKey("news_item")) {
            this.news = jsonObject.toJavaObject(NewsContent.class);
        } else {
            this.video = jsonObject.toJavaObject(Video.class);
        }
    }

    public NewsContent getNews() {
        return news;
    }

    public Video getVideo() {
        return video;
    }
}
