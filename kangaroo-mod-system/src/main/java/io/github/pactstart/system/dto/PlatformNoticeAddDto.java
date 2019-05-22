package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.OperateDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatformNoticeAddDto extends OperateDto {

    private String title;

    private String content;
}
