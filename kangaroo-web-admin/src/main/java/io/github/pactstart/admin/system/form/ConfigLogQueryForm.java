package io.github.pactstart.admin.system.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ConfigLogQueryForm {
    /**
     * 命名空间
     */
    private String namespace;

    /**
     * 配置名称
     */
    private String name;
}
