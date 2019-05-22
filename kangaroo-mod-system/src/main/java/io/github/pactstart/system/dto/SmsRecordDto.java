package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SmsRecordDto extends BaseDto {

    private Integer id;

    private String templateId;

    private String content;

    private String params;

    private String phone;

    private Boolean success;

    private String remark;

    private String operator;

    private String operateIp;

    private Date operateTime;

}