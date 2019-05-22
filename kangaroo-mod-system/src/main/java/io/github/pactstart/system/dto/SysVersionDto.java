package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SysVersionDto extends BaseDto {

    private Integer id;

    /**
     * 版本状态，1草稿，2已发布，3已回滚，4已删除
     */
    private Integer status;

    /**
     * 版本归属，1-Android,2-iOS,3-Backend,4-Frontend
     */
    private String versionOwner;

    /**
     * 平台：enterprise，appstore
     */
    private String platform;

    /**
     * 版本名称
     */
    private String versionName;

    /**
     * 版本顺序号
     */
    private Integer versionSeq;

    /**
     * 每个版本对应的git的tag
     */
    private String gitTag;

    /**
     * 是否兼容以前版本
     */
    private Boolean compatible;

    /**
     * 是否强制更新
     */
    private Boolean forceUpdate;

    /**
     * 版本概要
     */
    private String versionSummary;

    /**
     * 版本详情
     */
    private String versionDetail;

    /**
     * 版本时间
     */
    private Date versionTime;

    /**
     * 下载地址
     */
    private String downloadUrl;

    /**
     * 附件
     */
    private String attachs;

    /**
     * 操作时间
     */
    private Date operateTime;

    private String operator;

    private String operateIp;

}