package io.github.pactstart.weixin.mp.response.ip;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

import java.util.Arrays;
import java.util.List;

/**
 * 获取微信服务器的IP地址列表响应
 * Created by Di.Lei on 2017/7/26.
 */
public class CallbackIpResponse extends JsonResponse {

    private List<String> ipList;

    public void parseJSON(JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("ip_list");
        String[] array = jsonArray.toArray(new String[jsonArray.size()]);
        ipList = Arrays.asList(array);
    }

    public List<String> getIpList() {
        return ipList;
    }
}
