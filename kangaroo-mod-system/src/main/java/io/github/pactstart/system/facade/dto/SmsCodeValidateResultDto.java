package io.github.pactstart.system.facade.dto;

import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsCodeValidateResultDto extends BaseDto {

    private boolean success;

    private String failReason;
}
