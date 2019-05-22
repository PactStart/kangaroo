package io.github.pactstart.admin.system.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class ConfigAddForm {
    /**
     * 命名空间
     */
    @NotBlank(message = "命名空间不能为空")
    private String namespace;

    /**
     * 配置名称
     */
    @Length(max = 50, message = "配置名称长度不能超过50个字符")
    @NotBlank(message = "配置名称不能为空")
    private String name;

    /**
     * 配置值
     */
    @NotNull(message = "配置值不能为空")
    @Length(max = 255, message = "默认值长度不能超过255个字符")
    private String value;

    /**
     * 配置类型，1、bool，2、int，3、string、4、json
     */
    @NotNull(message = "配置类型不能为空")
    private Integer configType;

    /**
     * 默认值
     */
    @NotNull(message = "默认值不能为空")
    @Length(max = 255, message = "默认值长度不能超过255个字符")
    private String defaultValue;

    /**
     * 配置描述
     */
    @Length(max = 50, message = "配置描述长度不能超过50个字符")
    @NotBlank(message = "配置描述不能为空")
    private String description;

    /**
     * 配置值约束
     */
    private String jsonSchema;
}
