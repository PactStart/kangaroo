package io.github.pactstart.system.facade.dto;

import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SmsCodeValidateParamDto extends BaseDto {

    private String phone;

    private String code;

    private String templateId;

    /**
     * 校验通过后立即移除缓存的验证码
     */
    private boolean removeAfterPass;
}
