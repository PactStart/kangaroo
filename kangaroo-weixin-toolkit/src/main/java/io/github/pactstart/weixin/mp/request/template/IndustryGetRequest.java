package io.github.pactstart.weixin.mp.request.template;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.template.IndustryGetResponse;
import org.apache.http.HttpEntity;

/**
 * Created by Di.Lei on 2017/8/2.
 */
public class IndustryGetRequest extends AbstractAccessTokenRequest<IndustryGetResponse> {
    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/template/get_industry?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }
}
