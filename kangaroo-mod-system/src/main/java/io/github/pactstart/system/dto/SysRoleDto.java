package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SysRoleDto extends BaseDto {

    private Integer id;

    private String name;

    private Integer type;

    private Integer status;

    private String remark;

    private Date operateTime;

    private String operator;

    private String operateIp;

}