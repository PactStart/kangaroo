package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SmsDayCountAdaptDto extends BaseDto {

    private String dateStr;

    private Integer success;

    private Integer fail;

    private Integer total;

    private boolean absent;

}