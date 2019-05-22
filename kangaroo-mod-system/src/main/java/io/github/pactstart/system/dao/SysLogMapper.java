package io.github.pactstart.system.dao;

import io.github.pactstart.basedao.MyMapper;
import io.github.pactstart.system.entity.SysLog;

import java.util.List;

public interface SysLogMapper extends MyMapper<SysLog> {

    List<SysLog> query(Object condition);
}