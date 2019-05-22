package io.github.pactstart.weixin.mp.response.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;
import io.github.pactstart.weixin.mp.vo.UserInfo;

import java.util.List;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class BatchGetUserInfoResponse extends JsonResponse {

    private List<UserInfo> userInfoList;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.userInfoList = JSON.parseArray(jsonObject.getJSONArray("user_info_list").toJSONString(), UserInfo.class);
    }

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }
}
