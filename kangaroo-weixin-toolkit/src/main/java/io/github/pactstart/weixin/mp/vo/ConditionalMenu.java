package io.github.pactstart.weixin.mp.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by Rex.Lei on 2017/7/27.
 */
public class ConditionalMenu extends Menu implements Serializable {

    @JSONField(name = "matchrule")
    private MatchRule rule;

    public MatchRule getRule() {
        return rule;
    }

    public void setRule(MatchRule rule) {
        this.rule = rule;
    }
}
