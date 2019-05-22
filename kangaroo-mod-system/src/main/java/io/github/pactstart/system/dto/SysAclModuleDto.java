package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SysAclModuleDto extends BaseDto {

    private Integer id;

    private String name;

    private Integer parentId;

    private String level;

    private Integer seq;

    private Integer status;

    private String remark;

    private Date operateTime;

    private String operator;

    private String operateIp;

}