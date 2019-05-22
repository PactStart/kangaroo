package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SmsTemplateDto extends BaseDto {

    private String templateId;

    /**
     * 模板类型，1通知短信，2验证短信
     */
    private Integer type;

    /**
     * 模板内容
     */
    private String template;

    /**
     * 最后一次修改人
     */
    private String operator;

    /**
     * 最后一次修改时间
     */
    private Date operateTime;
}
