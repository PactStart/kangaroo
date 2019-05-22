package io.github.pactstart.system.facade.dto;

import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SmsSendResultDto extends BaseDto {

    private boolean success;

    private String failReason;


}
