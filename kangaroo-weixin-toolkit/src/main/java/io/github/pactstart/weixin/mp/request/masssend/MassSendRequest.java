package io.github.pactstart.weixin.mp.request.masssend;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.enums.MassSendMsgType;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.masssend.MassSendResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Di.Lei on 2017/8/6.
 */
public class MassSendRequest extends AbstractAccessTokenRequest<MassSendResponse> {

    private String tagId;

    private List<String> openIdList;

    private MassSendMsgType msgType;

    private Map<String, Object> msgData = new HashMap<>(4);

    /**
     * 图文消息被判定为转载时，是否继续群发。
     * 1为继续群发（转载），0为停止群发。该参数默认为0。
     */
    private Integer sendIgnoreReprint;

    public MassSendRequest(String tagId, MassSendMsgType msgType) {
        this.tagId = tagId;
        this.msgType = msgType;
    }

    public MassSendRequest(List<String> openIdList, MassSendMsgType msgType) {
        this.openIdList = openIdList;
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
        if (tagId != null) {
            return "/cgi-bin/message/mass/sendall?access_token=" + getAccessToken();
        } else {
            return "/cgi-bin/message/mass/send?access_token=" + getAccessToken();
        }
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        if (tagId != null) {
            JSONObject filter = new JSONObject();
            filter.put("is_to_all", false);
            filter.put("tagId", tagId);
            jsonObject.put("fiter", filter);
        } else {
            jsonObject.put("touser", openIdList);
        }
        jsonObject.put("msgtype", msgType.name());
        jsonObject.put(msgType.name(), msgData);
        return new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
    }
}
