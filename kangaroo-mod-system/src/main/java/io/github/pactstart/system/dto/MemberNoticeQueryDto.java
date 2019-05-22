package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.PageQueryDto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MemberNoticeQueryDto extends PageQueryDto {

    private Integer memberId;

    private Integer status;

    private Integer bizType;

    private Integer showType;

    private Boolean readed;
}
