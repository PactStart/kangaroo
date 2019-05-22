package io.github.pactstart.system.facade.dto;

import io.github.pactstart.biz.common.dto.OperateDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Getter
@Setter
@Builder
@ToString
public class SmsSendParamDto extends OperateDto {

    @NotBlank(message = "手机号不能为空")
    @Length(min = 11, max = 11, message = "手机号长度必须为11位")
    private String phone;

    @NotBlank(message = "短信模板id不能为空")
    private String templateId;

    @NotNull(message = "短信签名不能不能为空")
    private String signName;

    @Range(min = 4, max = 6, message = "短信验证码长度4-6位")
    private int codeLength = 6;

    private Map<String, String> params;
}
