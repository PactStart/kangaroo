package io.github.pactstart.weixin.mp.request.user;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.response.DefaultJsonResponse;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * Created by Di.Lei on 2017/8/12.
 */
public class UpdateUserRemarkRequest extends AbstractAccessTokenRequest<DefaultJsonResponse> {

    private String openid;

    private String remark;

    public UpdateUserRemarkRequest(String openid, String remark) {
        this.openid = openid;
        this.remark = remark;
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/user/info/updateremark?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("openid", openid);
        jsonObject.put("remark", remark);
        return new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
    }
}
