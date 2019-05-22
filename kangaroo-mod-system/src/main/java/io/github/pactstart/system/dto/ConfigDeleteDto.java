package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.OperateDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ConfigDeleteDto extends OperateDto {

    private String namespace;

    private String name;

}
