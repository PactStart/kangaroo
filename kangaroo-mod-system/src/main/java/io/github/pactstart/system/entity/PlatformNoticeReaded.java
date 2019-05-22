package io.github.pactstart.system.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "platform_notice_readed")
public class PlatformNoticeReaded {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "platform_notice_id")
    private Integer platformNoticeId;

    /**
     * 会员id
     */
    @Column(name = "member_id")
    private Integer memberId;

    /**
     * 阅读时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * @return platform_notice_id
     */
    public Integer getPlatformNoticeId() {
        return platformNoticeId;
    }

    /**
     * @param platformNoticeId
     */
    public void setPlatformNoticeId(Integer platformNoticeId) {
        this.platformNoticeId = platformNoticeId;
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

    /**
     * 获取阅读时间
     *
     * @return create_time - 阅读时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置阅读时间
     *
     * @param createTime 阅读时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}