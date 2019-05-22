package io.github.pactstart.system.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sys_version")
public class SysVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 版本状态，1草稿，2已发布，3已回滚，4已删除
     */
    private Integer status;

    /**
     * 版本归属，1-Android,2-iOS,3-Backend,4-Frontend
     */
    @Column(name = "version_owner")
    private String versionOwner;

    /**
     * 平台：enterprise，appstore
     */
    @Column(name = "platform")
    private String platform;

    /**
     * 版本名称
     */
    @Column(name = "version_name")
    private String versionName;

    /**
     * 版本顺序号
     */
    @Column(name = "version_seq")
    private Integer versionSeq;

    /**
     * 每个版本对应的git的tag
     */
    @Column(name = "git_tag")
    private String gitTag;

    /**
     * 是否兼容以前版本
     */
    private Boolean compatible;

    /**
     * 是否强制更新
     */
    @Column(name = "force_update")
    private Boolean forceUpdate;

    /**
     * 版本概要
     */
    @Column(name = "version_summary")
    private String versionSummary;

    /**
     * 版本详情
     */
    @Column(name = "version_detail")
    private String versionDetail;

    /**
     * 版本发布时间
     */
    @Column(name = "version_time")
    private Date versionTime;

    /**
     * 下载地址
     */
    @Column(name = "download_url")
    private String downloadUrl;

    /**
     * 附件
     */
    private String attachs;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    @Column(name = "operate_time")
    private Date operateTime;

}