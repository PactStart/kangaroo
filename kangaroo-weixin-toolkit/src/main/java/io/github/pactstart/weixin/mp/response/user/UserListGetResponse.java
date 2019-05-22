package io.github.pactstart.weixin.mp.response.user;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class UserListGetResponse extends JsonResponse {

    private int total;

    private int count;

    private List<String> openidList;

    private String nextOpenid;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.total = jsonObject.getInteger("total");
        this.count = jsonObject.getInteger("count");
        this.nextOpenid = jsonObject.getString("next_openid");
        JSONObject data = jsonObject.getJSONObject("data");
        if (data != null) {
            JSONArray array = data.getJSONArray("openid");
            if (array != null && array.size() > 0) {
                openidList = new ArrayList<>(array.size() * 2);
                for (int i = 0; i < array.size(); i++) {
                    openidList.add(array.getString(i));
                }
            }
        }
    }

    public int getTotal() {
        return total;
    }

    public int getCount() {
        return count;
    }

    public List<String> getOpenidList() {
        return openidList;
    }

    public String getNextOpenid() {
        return nextOpenid;
    }
}
