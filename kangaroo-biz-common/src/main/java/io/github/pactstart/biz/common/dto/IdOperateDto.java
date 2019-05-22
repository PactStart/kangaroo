package io.github.pactstart.biz.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdOperateDto extends BaseDto {

    private Integer id;

    private String operator;

    private String operateIp;
}
