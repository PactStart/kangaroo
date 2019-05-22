package io.github.pactstart.biz.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperateDto extends BaseDto{

    private String operator;

    private String operateIp;
}
