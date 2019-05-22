package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatformNoticeReadDto extends BaseDto {

    private Integer platformNoticeId;

    private Integer memberId;
}
