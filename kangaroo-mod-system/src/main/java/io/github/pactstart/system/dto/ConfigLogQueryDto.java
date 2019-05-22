package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.PageQueryDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ConfigLogQueryDto extends PageQueryDto {
    /**
     * 命名空间
     */
    private String namespace;

    /**
     * 配置名称
     */
    private String name;
}
