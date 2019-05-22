package io.github.pactstart.system.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sms_record")
public class SmsRecord {
    /**
     * 自增长主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "template_id")
    private String templateId;

    /**
     * 短信内容
     */
    private String content;

    /**
     * 短信参数，json格式
     */
    private String params;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 是否发送成功
     */
    private Boolean success;

    /**
     * 备注，失败时为失败原因
     */
    private String remark;

    /**
     * 发送者
     */
    private String operator;

    /**
     * 发送时间
     */
    @Column(name = "operate_time")
    private Date operateTime;

    /**
     * 发送者ip
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
     * @return template_id
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * @param templateId
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    /**
     * 获取短信内容
     *
     * @return content - 短信内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置短信内容
     *
     * @param content 短信内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取短信参数，json格式
     *
     * @return params - 短信参数，json格式
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置短信参数，json格式
     *
     * @param params 短信参数，json格式
     */
    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取是否发送成功
     *
     * @return success - 是否发送成功
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * 设置是否发送成功
     *
     * @param success 是否发送成功
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * 获取备注，失败时为失败原因
     *
     * @return remark - 备注，失败时为失败原因
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注，失败时为失败原因
     *
     * @param remark 备注，失败时为失败原因
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取发送者
     *
     * @return operator - 发送者
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置发送者
     *
     * @param operator 发送者
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 获取发送时间
     *
     * @return operator_time - 发送时间
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * 设置发送时间
     *
     * @param operateTime 发送时间
     */
    public void setOperatorTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * 获取发送者ip
     *
     * @return operate_ip - 发送者ip
     */
    public String getOperatorIp() {
        return operateIp;
    }

    /**
     * 设置发送者ip
     *
     * @param operateIp 发送者ip
     */
    public void setOperatorIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }
}