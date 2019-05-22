package io.github.pactstart.system.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigLogDto {

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
     * 原来的配置值
     */
    private String oldValue;

    /**
     * 新的配置值
     */
    private String newValue;

    /**
     * 操作者
     */
    private String operator;

    /**
     * 更新时间
     */
    private Date operateTime;

    /**
     * 更新者的ip地址
     */
    private String operateIp;
}
