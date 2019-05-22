package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberNoticeReadDto extends BaseDto {

    private Long id;

    private Integer memberId;
}
