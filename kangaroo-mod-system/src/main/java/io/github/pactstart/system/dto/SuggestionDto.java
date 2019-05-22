package io.github.pactstart.system.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SuggestionDto {

    private Integer id;

    /**
     * 来源
     */
    private Integer source;

    /**
     * 用户id
     */
    private Integer memberId;

    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 问题类型(0-功能异常，1-设计不合理，2-其他问题)
     */
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
    private Date operateTime;
}
