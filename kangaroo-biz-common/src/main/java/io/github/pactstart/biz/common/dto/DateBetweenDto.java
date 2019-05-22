package io.github.pactstart.biz.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DateBetweenDto extends BaseDto{

    private Date fromDate;

    private Date toDate;
}
