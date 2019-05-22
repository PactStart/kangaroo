package io.github.pactstart.weixin.mp.request.template;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.common.response.DefaultJsonResponse;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.vo.ValueColor;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Di.Lei on 2017/8/4.
 */
public class TemplateSubscribeRequest extends AbstractAccessTokenRequest<DefaultJsonResponse> {

    private String toUser;

    private String templateId;

    private String url;

    /**
     * 消息标题，15字以内
     */
    private String title;

    private String scence = "get_confirm";

    private Map<String, ValueColor> data = new HashMap<>();

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/message/template/subscribe?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("touser", toUser);
        jsonObject.put("template_id", templateId);
        jsonObject.put("url", url);
        jsonObject.put("title", title);
        jsonObject.put("scence", scence);
        jsonObject.put("param", data);
        return new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScence() {
        return scence;
    }

    public void setScence(String scence) {
        this.scence = scence;
    }

    public Map<String, ValueColor> getData() {
        return data;
    }

    public void setData(Map<String, ValueColor> data) {
        this.data = data;
    }
}
