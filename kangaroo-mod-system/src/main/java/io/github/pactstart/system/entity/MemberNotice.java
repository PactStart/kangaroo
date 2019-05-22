package io.github.pactstart.system.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "member_notice")
public class MemberNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 会员id
     */
    @Column(name = "member_id")
    private Integer memberId;

    /**
     * 会员昵称
     */
    private String nickname;

    /**
     * 发送状态，0正在发送，1发送成功，2发送失败
     */
    private Integer status;

    /**
     * 业务类型
     */
    @Column(name = "biz_type")
    private Integer bizType;

    /**
     * 显示类型
     */
    @Column(name = "show_type")
    private Integer showType;

    /**
     * 标题
     */
    private String title;

    /**
     * 通知内容
     */
    private String content;

    /**
     * 是否已读
     */
    private Boolean readed;

    /**
     * 通知时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否删除
     */
    private Boolean del;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取会员id
     *
     * @return member_id - 会员id
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 设置会员id
     *
     * @param memberId 会员id
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取发送状态，0正在发送，1发送成功，2发送失败
     *
     * @return status - 发送状态，0正在发送，1发送成功，2发送失败
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置发送状态，0正在发送，1发送成功，2发送失败
     *
     * @param status 发送状态，0正在发送，1发送成功，2发送失败
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取业务类型
     *
     * @return biz_type - 业务类型
     */
    public Integer getBizType() {
        return bizType;
    }

    /**
     * 设置业务类型
     *
     * @param bizType 业务类型
     */
    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    /**
     * 获取显示类型
     *
     * @return show_type - 显示类型
     */
    public Integer getShowType() {
        return showType;
    }

    /**
     * 设置显示类型
     *
     * @param showType 显示类型
     */
    public void setShowType(Integer showType) {
        this.showType = showType;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取通知内容
     *
     * @return content - 通知内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置通知内容
     *
     * @param content 通知内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取是否已读
     *
     * @return readed - 是否已读
     */
    public Boolean getReaded() {
        return readed;
    }

    /**
     * 设置是否已读
     *
     * @param readed 是否已读
     */
    public void setReaded(Boolean readed) {
        this.readed = readed;
    }

    /**
     * 获取通知时间
     *
     * @return create_time - 通知时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置通知时间
     *
     * @param createTime 通知时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取是否删除
     *
     * @return del - 是否删除
     */
    public Boolean getDel() {
        return del;
    }

    /**
     * 设置是否删除
     *
     * @param del 是否删除
     */
    public void setDel(Boolean del) {
        this.del = del;
    }
}