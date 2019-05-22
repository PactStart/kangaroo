package io.github.pactstart.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "sys_log")
public class SysLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系
     */
    private Integer type;

    /**
     * 基于type后指定的对象id，比如用户、权限、角色等表的主键
     */
    @Column(name = "target_id")
    private Integer targetId;

    /**
     * 操作者
     */
    private String operator;

    /**
     * 最后一次更新的时间
     */
    @Column(name = "operate_time")
    private Date operateTime;

    /**
     * 最后一次更新者的ip地址
     */
    @Column(name = "operate_ip")
    private String operateIp;

    /**
     * 当前是否复原过，0：没有，1：复原过
     */
    private Integer status;

    /**
     * 旧值
     */
    @Column(name = "old_value")
    private String oldValue;

    /**
     * 新值
     */
    @Column(name = "new_value")
    private String newValue;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系
     *
     * @return type - 权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系
     *
     * @param type 权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取基于type后指定的对象id，比如用户、权限、角色等表的主键
     *
     * @return target_id - 基于type后指定的对象id，比如用户、权限、角色等表的主键
     */
    public Integer getTargetId() {
        return targetId;
    }

    /**
     * 设置基于type后指定的对象id，比如用户、权限、角色等表的主键
     *
     * @param targetId 基于type后指定的对象id，比如用户、权限、角色等表的主键
     */
    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
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
     * 获取最后一次更新的时间
     *
     * @return operate_time - 最后一次更新的时间
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * 设置最后一次更新的时间
     *
     * @param operateTime 最后一次更新的时间
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * 获取最后一次更新者的ip地址
     *
     * @return operate_ip - 最后一次更新者的ip地址
     */
    public String getOperateIp() {
        return operateIp;
    }

    /**
     * 设置最后一次更新者的ip地址
     *
     * @param operateIp 最后一次更新者的ip地址
     */
    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }

    /**
     * 获取当前是否复原过，0：没有，1：复原过
     *
     * @return status - 当前是否复原过，0：没有，1：复原过
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置当前是否复原过，0：没有，1：复原过
     *
     * @param status 当前是否复原过，0：没有，1：复原过
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取旧值
     *
     * @return old_value - 旧值
     */
    public String getOldValue() {
        return oldValue;
    }

    /**
     * 设置旧值
     *
     * @param oldValue 旧值
     */
    public void setOldValue(String oldValue) {
        this.oldValue = oldValue == null ? null : oldValue.trim();
    }

    /**
     * 获取新值
     *
     * @return new_value - 新值
     */
    public String getNewValue() {
        return newValue;
    }

    /**
     * 设置新值
     *
     * @param newValue 新值
     */
    public void setNewValue(String newValue) {
        this.newValue = newValue == null ? null : newValue.trim();
    }
}