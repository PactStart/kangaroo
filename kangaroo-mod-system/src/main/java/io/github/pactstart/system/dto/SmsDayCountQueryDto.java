package io.github.pactstart.system.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SmsDayCountQueryDto {

    private Date fromDate;

    private Date toDate;

    private Integer type = 0;

}
