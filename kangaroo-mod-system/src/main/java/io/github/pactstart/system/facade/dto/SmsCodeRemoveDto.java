package io.github.pactstart.system.facade.dto;

import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
@Builder
public class SmsCodeRemoveDto extends BaseDto {

    @NotBlank(message = "手机号不能为空")
    @Length(min = 11, max = 11, message = "手机号长度必须为11位")
    private String phone;

    @NotBlank(message = "短信模板id不能为空")
    private String templateId;

}
