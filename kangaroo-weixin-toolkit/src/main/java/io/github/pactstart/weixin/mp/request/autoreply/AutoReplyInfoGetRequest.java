package io.github.pactstart.weixin.mp.request.autoreply;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.autoreply.AutoReplyInfoGetResponse;
import org.apache.http.HttpEntity;

/**
 * Created by Di.Lei on 2017/8/3.
 */
public class AutoReplyInfoGetRequest extends AbstractAccessTokenRequest<AutoReplyInfoGetResponse> {
    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/get_current_autoreply_info?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }
}
