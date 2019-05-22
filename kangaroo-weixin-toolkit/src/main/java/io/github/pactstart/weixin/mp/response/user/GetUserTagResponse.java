package io.github.pactstart.weixin.mp.response.user;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class GetUserTagResponse extends JsonResponse {

    private List<Integer> tagIdList;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        JSONArray array = jsonObject.getJSONArray("tagid_list");
        if (array != null && array.size() > 0) {
            tagIdList = new ArrayList<>(array.size() * 2);
            for (int i = 0; i < array.size(); i++) {
                tagIdList.add(array.getInteger(i));
            }
        }
    }

    public List<Integer> getTagIdList() {
        return tagIdList;
    }
}
