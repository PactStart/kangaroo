package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.PageQueryDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyPlatformNoticeQueryDto extends PageQueryDto {

    private Integer memberId;

    private Boolean readed;

}
