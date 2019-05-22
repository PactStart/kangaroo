package io.github.pactstart.weixin.mp.request.kfmessage;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.response.Response;
import io.github.pactstart.weixin.mp.enums.KfMessageType;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * Created by Di.Lei on 2017/8/2.
 */
public abstract class KfMessageRequest<T extends Response> extends AbstractAccessTokenRequest<T> {

    /**
     * 微信用户openid
     */
    private String toUser;

    /**
     * 发送消息的客服
     */
    private String kfAccount;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/message/custom/send?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("touser", getToUser());
        jsonObject.put("msgtype", getMsgType());
        jsonObject.put(getMsgType().name(), getContent());
        if (StringUtils.isNotEmpty(kfAccount)) {
            JSONObject kf = new JSONObject();
            kf.put("kf_account", kfAccount);
            jsonObject.put("customservice", kf);
        }
        return new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getKfAccount() {
        return kfAccount;
    }

    public void setKfAccount(String kfAccount) {
        this.kfAccount = kfAccount;
    }

    public abstract KfMessageType getMsgType();

    public abstract JSONObject getContent();

}
