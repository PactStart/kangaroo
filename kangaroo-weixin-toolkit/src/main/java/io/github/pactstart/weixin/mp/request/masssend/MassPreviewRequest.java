package io.github.pactstart.weixin.mp.request.masssend;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.enums.MassSendMsgType;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.masssend.MassPreviewResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Di.Lei on 2017/8/7.
 */
public class MassPreviewRequest extends AbstractAccessTokenRequest<MassPreviewResponse> {

    private String openId;

    private String wxName;

    private MassSendMsgType msgType;

    private Map<String, Object> msgData = new HashMap<>(4);

    /**
     * 图文消息被判定为转载时，是否继续群发。
     * 1为继续群发（转载），0为停止群发。该参数默认为0。
     */
    private Integer sendIgnoreReprint;

    public MassPreviewRequest(String openId, String wxName, MassSendMsgType msgType) {
        this.openId = openId;
        this.wxName = wxName;
        this.msgType = msgType;
    }

    public void addText(String text) {
        msgData.put("content", text);
    }

    public void addVedio(String mediaId, String title, String description) {
        msgData.put("media_id", mediaId);
        msgData.put("title", title);
        msgData.put("description", description);
    }

    public void addMpNews(String mediaId, boolean sendIgnoreReprint) {
        msgData.put("media_id", mediaId);
        this.sendIgnoreReprint = sendIgnoreReprint ? 1 : 0;
    }

    public void addImage(String mediaId) {
        msgData.put("media_id", mediaId);
    }

    public void addMpVideo(String mediaId) {
        msgData.put("media_id", mediaId);
    }

    public void addWxCard(String cardId) {
        msgData.put("card_id", cardId);
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/message/mass/preview?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("touser", openId);
        jsonObject.put("towxname", wxName);
        jsonObject.put("msgtype", msgType.name());
        jsonObject.put(msgType.name(), msgData);
        return new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
    }
}
