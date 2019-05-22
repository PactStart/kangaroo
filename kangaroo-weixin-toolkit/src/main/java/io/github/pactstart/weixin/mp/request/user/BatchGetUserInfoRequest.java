package io.github.pactstart.weixin.mp.request.user;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.user.BatchGetUserInfoResponse;
import io.github.pactstart.weixin.mp.vo.OpenId;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.util.List;

/**
 * 批量获取用户信息
 * Created by Di.Lei on 2017/8/12.
 */
public class BatchGetUserInfoRequest extends AbstractAccessTokenRequest<BatchGetUserInfoResponse> {

    private List<OpenId> openidList;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/user/info/batchget?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user_list", openidList);
        return new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
    }

    public List<OpenId> getOpenidList() {
        return openidList;
    }

    public void setOpenidList(List<OpenId> openidList) {
        this.openidList = openidList;
    }
}
