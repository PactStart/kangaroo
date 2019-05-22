package io.github.pactstart.weixin.mp.request.template;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.enums.RequestMethod;
import io.github.pactstart.weixin.mp.request.AbstractAccessTokenRequest;
import io.github.pactstart.weixin.mp.response.template.TemplateSendResponse;
import io.github.pactstart.weixin.mp.vo.ValueColor;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Di.Lei on 2017/8/3.
 */
public class TemplateSendRequest extends AbstractAccessTokenRequest<TemplateSendResponse> {

    private String toUser;

    private String templateId;

    private String url;

    private String miniProgramAppId;

    private String miniProgramPagePath;

    private Map<String, ValueColor> data = new HashMap<>();

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getRequestPath() {
        return "/cgi-bin/message/template/send?access_token=" + getAccessToken();
    }

    @Override
    public HttpEntity getRequestEntity() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("touser", toUser);
        jsonObject.put("template_id", templateId);
        if (StringUtils.isNotEmpty(url)) {
            jsonObject.put("url", url);
        }
        if (StringUtils.isNotEmpty(miniProgramAppId) && StringUtils.isNotEmpty(miniProgramPagePath)) {
            JSONObject miniprogram = new JSONObject();
            miniprogram.put("appid", miniProgramAppId);
            miniprogram.put("pagepath", miniProgramPagePath);
            jsonObject.put("miniprogram", miniprogram);
        }
        jsonObject.put("data", data);
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

    public String getMiniProgramAppId() {
        return miniProgramAppId;
    }

    public void setMiniProgramAppId(String miniProgramAppId) {
        this.miniProgramAppId = miniProgramAppId;
    }

    public String getMiniProgramPagePath() {
        return miniProgramPagePath;
    }

    public void setMiniProgramPagePath(String miniProgramPagePath) {
        this.miniProgramPagePath = miniProgramPagePath;
    }

    public Map<String, ValueColor> getData() {
        return data;
    }

    public void setData(Map<String, ValueColor> data) {
        this.data = data;
    }
}
