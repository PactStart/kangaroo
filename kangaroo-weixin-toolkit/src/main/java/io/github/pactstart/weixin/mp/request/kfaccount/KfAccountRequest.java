package io.github.pactstart.weixin.mp.request.kfaccount;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.response.Response;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;


/**
 * Created by Di.Lei on 2017/8/2.
 */
public abstract class KfAccountRequest<T extends Response> extends AbstractAccessTokenRequest {

    /**
     * 完整客服账号，格式为：账号前缀@公众号微信号
     */
    private String kfAccount;

    /**
     * 客服昵称
     */
    private String nickname;

    /**
     * 客服账号登录密码，格式为密码明文的32位加密MD5值。
     * 该密码仅用于在公众平台官网的多客服功能中使用，若不使用多客服功能，则不必设置密码
     */
    private String password;

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("kf_account", kfAccount);
        jsonObject.put("nickname", password);
        jsonObject.put("password", password);
        return new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
    }

    public String getKfAccount() {
        return kfAccount;
    }

    public void setKfAccount(String kfAccount) {
        this.kfAccount = kfAccount;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
