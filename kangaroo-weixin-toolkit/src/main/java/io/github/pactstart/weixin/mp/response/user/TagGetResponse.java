package io.github.pactstart.weixin.mp.response.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;
import io.github.pactstart.weixin.mp.vo.Tag;

import java.util.List;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class TagGetResponse extends JsonResponse {

    private List<Tag> tagList;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        String json = jsonObject.getJSONArray("tags").toJSONString();
        this.tagList = JSON.parseArray(json, Tag.class);
    }

    public List<Tag> getTagList() {
        return tagList;
    }
}
