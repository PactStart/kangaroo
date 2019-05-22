package io.github.pactstart.system.dao;

import io.github.pactstart.basedao.MyMapper;
import io.github.pactstart.system.entity.ConfigLog;

import java.util.List;

public interface ConfigLogMapper extends MyMapper<ConfigLog> {

    List<ConfigLog> query(Object object);
}