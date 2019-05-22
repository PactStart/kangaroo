package io.github.pactstart.weixin.mp.request.material;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.material.TempMaterialGetResponse;
import org.apache.http.HttpEntity;

/**
 * Created by Di.Lei on 2017/8/4.
 */
public class TempMaterialGetRequest extends AbstractAccessTokenRequest<TempMaterialGetResponse> {

    private String mediaId;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/media/get?access_token=" + getAccessToken() + "&media_id=" + mediaId;
    }

    @Override
    public HttpEntity getRequestEntity() {
        return null;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
