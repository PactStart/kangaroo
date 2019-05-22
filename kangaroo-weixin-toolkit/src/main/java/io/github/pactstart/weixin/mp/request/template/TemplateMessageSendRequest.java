package io.github.pactstart.weixin.mp.request.template;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.template.TemplateMessageSendResponse;
import org.apache.http.HttpEntity;

/**
 * Created by Di.Lei on 2017/8/2.
 */
public class TemplateMessageSendRequest extends AbstractAccessTokenRequest<TemplateMessageSendResponse> {
    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/message/template/send?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }
}
