package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.OperateDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ConfigUpdateDto extends OperateDto {

    private Integer id;

    /**
     * 配置类型，1、bool，2、int，3、string、4、json
     */
    private Integer configType;

    /**
     * 配置值
     */
    private String value;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * 配置描述
     */
    private String description;

    /**
     * 配置值约束
     */
    private String jsonSchema;

}
