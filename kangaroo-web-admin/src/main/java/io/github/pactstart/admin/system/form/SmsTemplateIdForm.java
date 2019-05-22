package io.github.pactstart.admin.system.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class SmsTemplateIdForm {

    @Length(max = 16, message = "模板id长度不能超过16个字符")
    @NotBlank(message = "模板id不能为空")
    private String templateId;

}
