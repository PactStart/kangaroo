package io.github.pactstart.system.dao;

import io.github.pactstart.basedao.MyMapper;
import io.github.pactstart.system.entity.SmsDayCount;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SmsDayCountMapper extends MyMapper<SmsDayCount> {

    void deleteByPeriod(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

    List<SmsDayCount> query(Object obj);
}