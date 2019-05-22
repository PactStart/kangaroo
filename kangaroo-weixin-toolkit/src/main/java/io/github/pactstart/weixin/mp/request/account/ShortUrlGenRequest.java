package io.github.pactstart.weixin.mp.request.account;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.account.ShortUrlGenResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * Created by Di.Lei on 2017/8/5.
 */
public class ShortUrlGenRequest extends AbstractAccessTokenRequest<ShortUrlGenResponse> {

    private String longUrl;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/shorturl?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        return new StringEntity("{\"action\":\"long2short\",\"long_url\":\"" + longUrl + "\"}", ContentType.APPLICATION_JSON);
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
}
