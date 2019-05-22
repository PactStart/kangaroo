package io.github.pactstart.weixin.mp.response.template;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;
import io.github.pactstart.weixin.mp.enums.IndustryCode;

/**
 * Created by Di.Lei on 2017/8/2.
 */
public class IndustryGetResponse extends JsonResponse {

    private IndustryCode primaryIndustry;

    private IndustryCode secondaryIndustry;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        JSONObject primary = jsonObject.getJSONObject("primary_industry");
        primaryIndustry = IndustryCode.valueOf(primary.getString("first_class"), primary.getString("second_class"));
        JSONObject secondary = jsonObject.getJSONObject("secondary_industry");
        primaryIndustry = IndustryCode.valueOf(secondary.getString("first_class"), secondary.getString("second_class"));
    }

    public IndustryCode getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(IndustryCode primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public IndustryCode getSecondaryIndustry() {
        return secondaryIndustry;
    }

    public void setSecondaryIndustry(IndustryCode secondaryIndustry) {
        this.secondaryIndustry = secondaryIndustry;
    }
}
