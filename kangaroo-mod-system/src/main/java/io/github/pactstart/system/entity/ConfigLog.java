package io.github.pactstart.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "config_log")
public class ConfigLog {
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
     * 原类型
     */
    @Column(name = "old_type")
    private Integer oldType;

    /**
     * 现类型
     */
    @Column(name = "new_type")
    private Integer newType;

    /**
     * 原来的配置值
     */
    @Column(name = "old_value")
    private String oldValue;

    /**
     * 新的配置值
     */
    @Column(name = "new_value")
    private String newValue;

    /**
     * 操作者
     */
    private String operator;

    /**
     * 更新时间
     */
    @Column(name = "operate_time")
    private Date operateTime;

    /**
     * 更新者的ip地址
     */
    @Column(name = "operate_ip")
    private String operateIp;

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
     * 获取原来的配置值
     *
     * @return old_value - 原来的配置值
     */
    public String getOldValue() {
        return oldValue;
    }

    /**
     * 设置原来的配置值
     *
     * @param oldValue 原来的配置值
     */
    public void setOldValue(String oldValue) {
        this.oldValue = oldValue == null ? null : oldValue.trim();
    }

    /**
     * 获取新的配置值
     *
     * @return new_value - 新的配置值
     */
    public String getNewValue() {
        return newValue;
    }

    /**
     * 设置新的配置值
     *
     * @param newValue 新的配置值
     */
    public void setNewValue(String newValue) {
        this.newValue = newValue == null ? null : newValue.trim();
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
     * 获取更新时间
     *
     * @return operate_time - 更新时间
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * 设置更新时间
     *
     * @param operateTime 更新时间
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * 获取更新者的ip地址
     *
     * @return operate_ip - 更新者的ip地址
     */
    public String getOperateIp() {
        return operateIp;
    }

    /**
     * 设置更新者的ip地址
     *
     * @param operateIp 更新者的ip地址
     */
    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }
}