package io.github.pactstart.weixin.mp.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class UserInfo {

    private int subscribe;

    private String openid;

    private String headimgurl;

    private int sex;

    private String language;

    private String city;

    private String province;

    private String country;

    private String headinmgurl;

    @JSONField(name = "subscribe_tiem")
    private Long subscribeTime;

    private String unionid;

    private String remark;

    private int groupid;

    /**
     * 逗号分隔，例如[128,2]
     */
    @JSONField(name = "tagid_list")
    private String tagIds;

    public int getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(int subscribe) {
        this.subscribe = subscribe;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadinmgurl() {
        return headinmgurl;
    }

    public void setHeadinmgurl(String headinmgurl) {
        this.headinmgurl = headinmgurl;
    }

    public Long getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Long subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }
}
