package io.github.pactstart.system.service;

import io.github.pactstart.biz.common.dto.DateBetweenDto;
import io.github.pactstart.system.dto.SmsDayCountAdaptDto;
import io.github.pactstart.system.dto.SmsDayCountQueryDto;

import java.util.Date;
import java.util.List;

public interface SmsDayCountService {

    void statByDate(Date fromDate, Date toDate);

    List<SmsDayCountAdaptDto> query(SmsDayCountQueryDto queryDto);

    void statByDate(DateBetweenDto dateBetweenDto);
}
