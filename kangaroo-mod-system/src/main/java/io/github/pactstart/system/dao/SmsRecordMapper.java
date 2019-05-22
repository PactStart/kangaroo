package io.github.pactstart.system.dao;

import io.github.pactstart.basedao.MyMapper;
import io.github.pactstart.system.entity.SmsRecord;
import io.github.pactstart.system.model.SmsStat;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SmsRecordMapper extends MyMapper<SmsRecord> {

    List<SmsRecord> query(Object obj);

    List<SmsStat> statByDate(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
}