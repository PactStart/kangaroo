package io.github.pactstart.weixin.mp.response.user;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;
import io.github.pactstart.weixin.mp.vo.UserInfo;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class UserInfoGetResponse extends JsonResponse {

    private UserInfo userInfo;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.userInfo = jsonObject.toJavaObject(UserInfo.class);
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
}
