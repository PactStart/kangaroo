package io.github.pactstart.weixin.mp.request.kfaccount;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.kfaccount.KfAccountListGetResponse;
import org.apache.http.HttpEntity;

/**
 * Created by Di.Lei on 2017/8/2.
 */
public class KfAccountListGetRequest extends AbstractAccessTokenRequest<KfAccountListGetResponse> {
    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/customservice/getkflist?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }
}
