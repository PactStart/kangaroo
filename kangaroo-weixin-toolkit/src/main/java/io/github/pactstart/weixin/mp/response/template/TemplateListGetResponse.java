package io.github.pactstart.weixin.mp.response.template;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;
import io.github.pactstart.weixin.mp.vo.Template;

import java.util.List;

/**
 * Created by Di.Lei on 2017/8/3.
 */
public class TemplateListGetResponse extends JsonResponse {

    private List<Template> templateList;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        templateList = JSON.parseArray(jsonObject.getJSONArray("template_list").toJSONString(), Template.class);
    }

    public List<Template> getTemplateList() {
        return templateList;
    }

    public void setTemplateList(List<Template> templateList) {
        this.templateList = templateList;
    }
}
