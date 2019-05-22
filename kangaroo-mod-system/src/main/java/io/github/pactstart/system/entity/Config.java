package io.github.pactstart.system.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Config {
    /**
     * 自增长主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
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
    @Column(name = "config_type")
    private Integer configType;

    /**
     * 默认值
     */
    @Column(name = "default_value")
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
    @Column(name = "operate_time")
    private Date operateTime;

    /**
     * 最后一个更新者的ip地址
     */
    @Column(name = "operate_ip")
    private String operateIp;

    /**
     * 配置值约束
     */
    @Column(name = "json_schema")
    private String jsonSchema;

    /**
     * 获取自增长主键
     *
     * @return id - 自增长主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增长主键
     *
     * @param id 自增长主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取命名空间
     *
     * @return namespace - 命名空间
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * 设置命名空间
     *
     * @param namespace 命名空间
     */
    public void setNamespace(String namespace) {
        this.namespace = namespace == null ? null : namespace.trim();
    }

    /**
     * 获取配置名称
     *
     * @return name - 配置名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置配置名称
     *
     * @param name 配置名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取配置值
     *
     * @return value - 配置值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置配置值
     *
     * @param value 配置值
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * 获取配置类型，1、bool，2、int，3、string、4、json
     *
     * @return config_type - 配置类型，1、bool，2、int，3、string、4、json
     */
    public Integer getConfigType() {
        return configType;
    }

    /**
     * 设置配置类型，1、bool，2、int，3、string、4、json
     *
     * @param configType 配置类型，1、bool，2、int，3、string、4、json
     */
    public void setConfigType(Integer configType) {
        this.configType = configType;
    }

    /**
     * 获取默认值
     *
     * @return default_value - 默认值
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * 设置默认值
     *
     * @param defaultValue 默认值
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    /**
     * 获取配置描述
     *
     * @return description - 配置描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置配置描述
     *
     * @param description 配置描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取操作者
     *
     * @return operator - 操作者
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置操作者
     *
     * @param operator 操作者
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 获取最后一次更新时间
     *
     * @return operate_time - 最后一次更新时间
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * 设置最后一次更新时间
     *
     * @param operateTime 最后一次更新时间
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * 获取最后一个更新者的ip地址
     *
     * @return operate_ip - 最后一个更新者的ip地址
     */
    public String getOperateIp() {
        return operateIp;
    }

    /**
     * 设置最后一个更新者的ip地址
     *
     * @param operateIp 最后一个更新者的ip地址
     */
    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }

    /**
     * 获取配置值约束
     *
     * @return json_schema - 配置值约束
     */
    public String getJsonSchema() {
        return jsonSchema;
    }

    /**
     * 设置配置值约束
     *
     * @param jsonSchema 配置值约束
     */
    public void setJsonSchema(String jsonSchema) {
        this.jsonSchema = jsonSchema == null ? null : jsonSchema.trim();
    }
}