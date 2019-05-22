package io.github.pactstart.weixin.mp.request.account;

import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.account.SceneQrCodeCreateResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * Created by Di.Lei on 2017/8/5.
 */
public class SceneQrCodeCreateRequest extends AbstractAccessTokenRequest<SceneQrCodeCreateResponse> {

    private int sceneId;

    private String sceneStr;

    private Integer expireSeconds;

    private String actionName;

    public SceneQrCodeCreateRequest(int sceneId, int expireSeconds) {
        this.sceneId = sceneId;
        this.expireSeconds = expireSeconds;
        this.actionName = "QR_SCENE";
    }

    public SceneQrCodeCreateRequest(String sceneStr, int expireSeconds) {
        this.sceneStr = sceneStr;
        this.expireSeconds = expireSeconds;
        this.actionName = "QR_STR_SCENE";
    }

    public SceneQrCodeCreateRequest(int sceneId) {
        this.sceneId = sceneId;
        this.actionName = "QR_LIMIT_SCENE";
    }

    public SceneQrCodeCreateRequest(String sceneStr) {
        this.sceneStr = sceneStr;
        this.actionName = "QR_LIMIT_STR_SCENE";
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/qrcode/create?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (expireSeconds != null) {
            sb.append("\"expire_seconds\":").append("\"").append(expireSeconds).append("\",");
        }
        sb.append("\"action_name\":").append("\"").append(actionName).append("\",");
        sb.append("\"action_info\":{\"scene\":{");
        if (sceneStr != null) {
            sb.append("\"").append(sceneId).append("\":").append(sceneId);
        } else {
            sb.append("\"").append(sceneStr).append("\":\"").append(sceneStr).append("\"");
        }
        sb.append("}}}");
        return new StringEntity(sb.toString(), ContentType.APPLICATION_JSON);
    }
}
