package io.github.pactstart.weixin.mp.request.template;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.response.DefaultJsonResponse;
import io.github.pactstart.weixin.mp.enums.IndustryCode;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * Created by Di.Lei on 2017/8/2.
 */
public class IndustrySetRequest extends AbstractAccessTokenRequest<DefaultJsonResponse> {

    private IndustryCode primaryIndustry;

    private IndustryCode secondaryIndustry;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/template/api_set_industry?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("industry_id1", primaryIndustry.getCode());
        jsonObject.put("industry_id2", secondaryIndustry.getCode());
        return new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
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
