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
@Table(name = "suggestion")
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 来源
     */
    private Integer source;

    /**
     * 用户id
     */
    @Column(name = "member_id")
    private Integer memberId;

    /**
     * 联系方式
     */
    @Column(name = "contact_info")
    private String contactInfo;

    /**
     * 问题类型(0-功能异常，1-设计不合理，2-其他问题)
     */
    @Column(name = "problem_type")
    private Integer problemType;

    /**
     * 建议内容
     */
    private String content;

    /**
     * 附件
     */
    private String attachs;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 回复
     */
    private String reply;

    /**
     * 处理人
     */
    private String operator;

    /**
     * 处理时间
     */
    @Column(name = "operate_time")
    private Date operateTime;

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
     * 获取来源
     *
     * @return source - 来源
     */
    public Integer getSource() {
        return source;
    }

    /**
     * 设置来源
     *
     * @param source 来源
     */
    public void setSource(Integer source) {
        this.source = source;
    }

    /**
     * 获取用户id
     *
     * @return member_id - 用户id
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 设置用户id
     *
     * @param memberId 用户id
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取联系方式
     *
     * @return contact_info - 联系方式
     */
    public String getContactInfo() {
        return contactInfo;
    }

    /**
     * 设置联系方式
     *
     * @param contactInfo 联系方式
     */
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo == null ? null : contactInfo.trim();
    }

    /**
     * 获取问题类型(0-功能异常，1-设计不合理，2-其他问题)
     *
     * @return problem_type - 问题类型(0-功能异常，1-设计不合理，2-其他问题)
     */
    public Integer getProblemType() {
        return problemType;
    }

    /**
     * 设置问题类型(0-功能异常，1-设计不合理，2-其他问题)
     *
     * @param problemType 问题类型(0-功能异常，1-设计不合理，2-其他问题)
     */
    public void setProblemType(Integer problemType) {
        this.problemType = problemType;
    }

    /**
     * 获取建议内容
     *
     * @return content - 建议内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置建议内容
     *
     * @param content 建议内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取附件
     *
     * @return attachs - 附件
     */
    public String getAttachs() {
        return attachs;
    }

    /**
     * 设置附件
     *
     * @param attachs 附件
     */
    public void setAttachs(String attachs) {
        this.attachs = attachs == null ? null : attachs.trim();
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取回复
     *
     * @return reply - 回复
     */
    public String getReply() {
        return reply;
    }

    /**
     * 设置回复
     *
     * @param reply 回复
     */
    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
    }

    /**
     * 获取处理人
     *
     * @return operator - 处理人
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置处理人
     *
     * @param operator 处理人
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 获取处理时间
     *
     * @return operate_time - 处理时间
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * 设置处理时间
     *
     * @param operateTime 处理时间
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
}