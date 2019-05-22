package io.github.pactstart.admin.system.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SmsTemplateAddForm {

    @Length(max = 16, message = "模板id长度不能超过16个字符")
    @NotBlank(message = "模板id不能为空")
    private String templateId;

    /**
     * 模板类型，1通知短信，2验证短信
     */
    @NotNull(message = "未选择短信模板类型")
    private Integer type;

    /**
     * 模板内容
     */
    @NotBlank(message = "模板不能为空")
    private String template;
}
