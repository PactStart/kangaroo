package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.PageQueryDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogQueryDto extends PageQueryDto {

    private Integer type;

    private String operator;

    private String fromTime;

    private String toTime;
}
