package io.github.pactstart.admin.system.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SysVersionForm {

    private Integer id;

    /**
     * 版本状态，1草稿，2已发布，3已回滚，4已删除
     */
    @NotNull(message = "状态不能为空")
    private Integer status;

    /**
     * 版本归属，Android,iOS,Backend,Frontend
     */
    @NotEmpty(message = "版本归属不能为空")
    private String versionOwner;

    /**
     * 平台
     */
    private String platform = "";

    /**
     * 版本名称
     */
    @NotBlank(message = "版本名称不能为空")
    private String versionName;

    /**
     * 版本顺序号
     */
    @NotNull(message = "版本顺序号不能为空")
    private Integer versionSeq;

    /**
     * 每个版本对应的git的tag
     */
    @NotNull(message = "Git Tag不能为空")
    private String gitTag;

    /**
     * 是否兼容以前版本
     */
    @NotNull(message = "未选择是否兼容以前版本")
    private Boolean compatible;

    /**
     * 是否强制更新
     */
    @NotNull(message = "未选择是否强制更新")
    private Boolean forceUpdate;

    /**
     * 版本概要
     */
    @NotBlank(message = "未填写版本概要")
    private String versionSummary;

    /**
     * 版本详情
     */
    @NotBlank(message = "未填写版本详情")
    private String versionDetail;

    /**
     * 版本时间
     */
    @NotNull(message = "未填写版本时间")
    private Date versionTime;

    /**
     * 下载地址
     */
    @NotEmpty(message = "未填写下载地址")
    private String downloadUrl;

    /**
     * 附件
     */
    private String attachs;


}