package io.github.pactstart.weixin.mp.response.user;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class TagAddResponse extends JsonResponse {

    private int id;

    private String tagName;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        JSONObject tag = jsonObject.getJSONObject("tag");
        this.id = tag.getInteger("id");
        this.tagName = tag.getString("name");
    }

    public int getId() {
        return id;
    }

    public String getTagName() {
        return tagName;
    }
}
