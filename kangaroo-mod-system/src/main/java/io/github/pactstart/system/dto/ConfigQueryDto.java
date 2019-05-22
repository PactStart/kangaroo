package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.PageQueryDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ConfigQueryDto extends PageQueryDto {
    /**
     * 命名空间
     */
    private String namespace;

    /**
     * 配置名称
     */
    private String name;

    /**
     * 配置类型，1、bool，2、int，3、string、4、json
     */
    private Integer configType;

    /**
     * 配置描述
     */
    private String description;
}
