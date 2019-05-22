package io.github.pactstart.weixin.mp.vo;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.pactstart.weixin.mp.enums.ClientPlatformType;
import io.github.pactstart.weixin.mp.enums.Language;
import io.github.pactstart.weixin.mp.enums.Sex;

import java.io.Serializable;

/**
 * Created by Rex.Lei on 2017/7/27.
 */
public class MatchRule implements Serializable {

    @JSONField(name = "tag_id")
    private String tagId;

    private String sex;

    private String country;

    private String province;

    @JSONField(name = "client_platform_type")
    private String clientPlatformType;

    private String language;

    public MatchRule() {
    }

    public MatchRule(String tagId, Sex sex, String country, String province, ClientPlatformType clientPlatformType, Language language) {
        this.tagId = tagId;
        this.sex = sex.getValue();
        this.country = country;
        this.province = province;
        this.clientPlatformType = clientPlatformType.getValue();
        this.language = language.getValue();
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getClientPlatformType() {
        return clientPlatformType;
    }

    public void setClientPlatformType(String clientPlatformType) {
        this.clientPlatformType = clientPlatformType;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
