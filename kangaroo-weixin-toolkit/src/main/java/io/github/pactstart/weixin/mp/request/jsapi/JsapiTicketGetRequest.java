package io.github.pactstart.weixin.mp.request.jsapi;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.jsapi.JsapiTicketGetResponse;
import org.apache.http.HttpEntity;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class JsapiTicketGetRequest extends AbstractAccessTokenRequest<JsapiTicketGetResponse> {
    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/ticket/getticket?access_token=" + getAccessToken() + "&type=jsapi";
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }
}
