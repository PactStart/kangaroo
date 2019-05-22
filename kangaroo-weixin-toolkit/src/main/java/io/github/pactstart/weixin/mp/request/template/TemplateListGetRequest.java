package io.github.pactstart.weixin.mp.request.template;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.template.TemplateListGetResponse;
import org.apache.http.HttpEntity;

/**
 * Created by Di.Lei on 2017/8/2.
 */
public class TemplateListGetRequest extends AbstractAccessTokenRequest<TemplateListGetResponse> {

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/template/get_all_private_template?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }
}
