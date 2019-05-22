package io.github.pactstart.system.dto;


import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ConfigDto extends BaseDto {

    private Integer id;

    /**
     * 命名空间
     */
    private String namespace;

    /**
     * 配置名称
     */
    private String name;

    /**
     * 配置值
     */
    private String value;

    /**
     * 配置类型，1、bool，2、int，3、string、4、json
     */
    private Integer configType;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * 配置描述
     */
    private String description;

    /**
     * 操作者
     */
    private String operator;

    /**
     * 最后一次更新时间
     */
    private Date operateTime;

    /**
     * 最后一个更新者的ip地址
     */
    private String operateIp;

    /**
     * 配置值约束
     */
    private String jsonSchema;
}
