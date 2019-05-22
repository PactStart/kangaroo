package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.PageQueryDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SmsRecordQueryDto extends PageQueryDto {

    private String templateId;

    private Integer scene;

    private String phone;

    private Date fromDate;

    private Date toDate;

    private Boolean success;
}
