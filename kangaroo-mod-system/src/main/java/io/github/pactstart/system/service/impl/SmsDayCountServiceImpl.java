package io.github.pactstart.system.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.github.pactstart.biz.common.dto.DateBetweenDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import io.github.pactstart.commonutils.DataUtils;
import io.github.pactstart.commonutils.ValidUtils;
import io.github.pactstart.system.dao.SmsDayCountMapper;
import io.github.pactstart.system.dao.SmsRecordMapper;
import io.github.pactstart.system.dto.SmsDayCountAdaptDto;
import io.github.pactstart.system.dto.SmsDayCountQueryDto;
import io.github.pactstart.system.entity.SmsDayCount;
import io.github.pactstart.system.model.SmsStat;
import io.github.pactstart.system.service.SmsDayCountService;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SmsDayCountServiceImpl implements SmsDayCountService {

    @Resource
    private SmsDayCountMapper smsDayCountMapper;

    @Resource
    private SmsRecordMapper smsRecordMapper;

    @Transactional
    @Override
    public void statByDate(DateBetweenDto dateBetweenDto) {
        statByDate(dateBetweenDto.getFromDate(), dateBetweenDto.getToDate());
    }

    @Override
    @Transactional
    public void statByDate(Date fromDate, Date toDate) {
        List<SmsStat> smsStats = smsRecordMapper.statByDate(fromDate, toDate);

        LocalDate start = LocalDate.fromDateFields(fromDate);
        LocalDate end = LocalDate.fromDateFields(toDate);
        List<SmsDayCount> dayCountList = Lists.newArrayList();
        while (start.isBefore(end)) {
            final LocalDate cur = start;
            Optional<SmsStat> first = smsStats.stream().filter((item) -> cur.isEqual(LocalDate.fromDateFields(item.getStatDate()))).findFirst();

            SmsDayCount dayCount = SmsDayCount.builder().year(cur.getYear()).month(cur.getMonthOfYear())
                    .day(cur.getDayOfMonth()).statTime(cur.toDate()).build();
            if (first.isPresent()) {
                SmsStat smsStat = first.get();
                dayCount.setSuccess(smsStat.getSuccess());
                dayCount.setFail(smsStat.getFail());
            } else {
                dayCount.setSuccess(0);
                dayCount.setFail(0);
            }
            dayCountList.add(dayCount);

            start = start.plusDays(1);
        }
        if (ValidUtils.isValid(dayCountList)) {
            smsDayCountMapper.deleteByPeriod(fromDate, toDate);
            smsDayCountMapper.insertList(dayCountList);
        }
    }

    @Override
    public List<SmsDayCountAdaptDto> query(SmsDayCountQueryDto queryDto) {
        //起始时间默认当前日期前7天
        LocalDate start = null;
        if (queryDto.getFromDate() == null) {
            start = LocalDate.now().minusDays(7);
            queryDto.setFromDate(start.toDate());
        } else {
            start = LocalDate.fromDateFields(queryDto.getFromDate());
        }
        //截止时间默认当前日期前7天
        LocalDate end = null;
        if (queryDto.getToDate() == null) {
            end = LocalDate.now().minusDays(1);
            queryDto.setToDate(end.toDate());
        } else {
            end = LocalDate.fromDateFields(queryDto.getToDate());
        }
        int days = Days.daysBetween(start, end).getDays();
        if (days > 90) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "时间跨度不能超过3个月");
        }
        List<SmsDayCount> dayCountList = smsDayCountMapper.query(queryDto);
        Map<String, SmsDayCount> mapping = Maps.newHashMap();
        dayCountList.forEach((dayCount) -> {
            String dateStr = DataUtils.getDateStr(dayCount.getYear(), dayCount.getMonth(), dayCount.getDay());
            mapping.put(dateStr, dayCount);
        });

        List<SmsDayCountAdaptDto> dayCountAdaptDtoList = Lists.newArrayList();
        while (!start.isAfter(end)) {
            LocalDate cur = start;
            String dateStr = DataUtils.getDateStr(cur.getYear(), cur.getMonthOfYear(), cur.getDayOfMonth());

            SmsDayCountAdaptDto dayCountAdaptDto = null;
            if (mapping.containsKey(dateStr)) {
                SmsDayCount dayCount = mapping.get(dateStr);
                dayCountAdaptDto = SmsDayCountAdaptDto.builder().dateStr(dateStr).success(dayCount.getSuccess())
                        .fail(dayCount.getFail()).total(dayCount.getSuccess() + dayCount.getFail()).absent(false).build();
            } else {
                dayCountAdaptDto = SmsDayCountAdaptDto.builder().dateStr(dateStr).success(0).fail(0).total(0).absent(true).build();
            }
            dayCountAdaptDtoList.add(dayCountAdaptDto);

            start = start.plusDays(1);
        }
        return dayCountAdaptDtoList;
    }


}
