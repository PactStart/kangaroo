package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.PageQueryDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysVersionQueryDto extends PageQueryDto {

    private String versionOwner;

    private Integer status;

    private String platform;

}
