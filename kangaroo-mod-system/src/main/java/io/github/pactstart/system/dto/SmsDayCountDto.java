package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SmsDayCountDto extends BaseDto {

    private Integer id;

    private Integer year;

    private Integer month;

    private Integer day;

    private Integer success;

    private Integer fail;

    private Date statTime;

}