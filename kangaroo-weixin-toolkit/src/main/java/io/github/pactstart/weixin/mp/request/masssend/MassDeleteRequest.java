package io.github.pactstart.weixin.mp.request.masssend;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.response.DefaultJsonResponse;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * Created by Di.Lei on 2017/8/7.
 */
public class MassDeleteRequest extends AbstractAccessTokenRequest<DefaultJsonResponse> {

    private String msgId;

    private int articleIndex;


    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/message/mass/delete?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        String json = "{\"msg_id\":\"" + msgId + "\",\"article_idx\":" + articleIndex + "}";
        return new StringEntity(json, ContentType.APPLICATION_JSON);
    }
}
