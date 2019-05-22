package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SysLogDto extends BaseDto {

    private Integer id;

    private Integer type;

    private Integer targetId;

    private String operator;

    private Date operateTime;

    private String operateIp;

    private Integer status;

    private String oldValue;

    private String newValue;

}