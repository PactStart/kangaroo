package io.github.pactstart.weixin.mp.response.sns;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class SNSUserInfoGetResponse extends JsonResponse {

    private String openid;

    private String nickname;

    private int sex;

    private String province;

    private String city;

    private String country;

    private String headimgurl;

    private String privilege;

    private String unionid;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.openid = jsonObject.getString("openid");
        this.nickname = jsonObject.getString("nickname");
        this.sex = Integer.valueOf(jsonObject.getString("sex"));
        this.province = jsonObject.getString("province");
        this.city = jsonObject.getString("city");
        this.country = jsonObject.getString("country");
        this.headimgurl = jsonObject.getString("headimgurl");
        this.privilege = jsonObject.getString("privilege");
        this.unionid = jsonObject.getString("unionid");
    }

    public String getOpenid() {
        return openid;
    }

    public String getNickname() {
        return nickname;
    }

    public int getSex() {
        return sex;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public String getPrivilege() {
        return privilege;
    }

    public String getUnionid() {
        return unionid;
    }
}
