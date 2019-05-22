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
public class ConfigUpdateForm {

    @NotNull(message = "id不能为空")
    private Integer id;

    /**
     * 配置值
     */
    @NotBlank(message = "配置值不能为空")
    private String value;

    @NotNull(message = "默认值不能为空")
    @Length(max = 255, message = "默认值长度不能超过255个字符")
    private String defaultValue;

    /**
     * 配置类型，1、bool，2、int，3、string、4、json
     */
    @NotNull(message = "配置类型不能为空")
    private Integer configType;

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
