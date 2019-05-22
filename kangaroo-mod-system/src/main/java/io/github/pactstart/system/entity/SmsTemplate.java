package io.github.pactstart.system.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sms_template")
public class SmsTemplate {
    /**
     * 模板id
     */
    @Id
    @Column(name = "template_id")
    private String templateId;

    /**
     * 模板类型，1通知短信，2验证短信
     */
    private Integer type;

    /**
     * 模板内容
     */
    private String template;

    /**
     * 最后一次修改人
     */
    private String operator;

    /**
     * 最后一次修改时间
     */
    @Column(name = "operate_time")
    private Date operateTime;

    /**
     * 获取模板id
     *
     * @return template_id - 模板id
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * 设置模板id
     *
     * @param templateId 模板id
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    /**
     * 获取模板类型，1通知短信，2验证短信
     *
     * @return type - 模板类型，1通知短信，2验证短信
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置模板类型，1通知短信，2验证短信
     *
     * @param type 模板类型，1通知短信，2验证短信
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取模板内容
     *
     * @return template - 模板内容
     */
    public String getTemplate() {
        return template;
    }

    /**
     * 设置模板内容
     *
     * @param template 模板内容
     */
    public void setTemplate(String template) {
        this.template = template == null ? null : template.trim();
    }

    /**
     * 获取最后一次修改人
     *
     * @return operator - 最后一次修改人
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置最后一次修改人
     *
     * @param operator 最后一次修改人
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 获取最后一次修改时间
     *
     * @return operate_time - 最后一次修改时间
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * 设置最后一次修改时间
     *
     * @param operateTime 最后一次修改时间
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
}