package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.OperateDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SysDeptDto extends OperateDto {
    private Integer id;

    private String name;

    private Integer parentId;

    private String level;

    private Integer seq;

    private String remark;

    private Date operateTime;

}