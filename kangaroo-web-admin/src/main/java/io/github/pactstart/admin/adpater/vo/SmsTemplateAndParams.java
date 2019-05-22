package io.github.pactstart.admin.adpater.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class SmsTemplateAndParams {

    private String signName;

    private String templateId;

    private Map<String, String> templateParams;

    private int codeLength = 6;

}
