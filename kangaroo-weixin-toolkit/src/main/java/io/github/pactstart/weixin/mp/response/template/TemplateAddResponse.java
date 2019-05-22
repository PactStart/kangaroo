package io.github.pactstart.weixin.mp.response.template;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

/**
 * Created by Di.Lei on 2017/8/3.
 */
public class TemplateAddResponse extends JsonResponse {

    private String templateId;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.templateId = jsonObject.getString("template_id_short");
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
}
