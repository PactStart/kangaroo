package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PlatformNoticeDto extends BaseDto {

    private Integer id;

    private Integer status;

    private String title;

    private String content;

    private Integer readCount;

    private Date createTime;

    private String operator;

    private Date operateTime;

    private String operateIp;

    private Boolean readed;

}