package io.github.pactstart.admin.system.form;

import io.github.pactstart.simple.web.framework.common.form.PageForm;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ConfigQueryForm extends PageForm {
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
