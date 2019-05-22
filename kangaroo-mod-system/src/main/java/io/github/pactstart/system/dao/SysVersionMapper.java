package io.github.pactstart.system.dao;

import io.github.pactstart.basedao.MyMapper;
import io.github.pactstart.system.entity.SysVersion;

import java.util.List;

public interface SysVersionMapper extends MyMapper<SysVersion> {

    List<SysVersion> query(Object object);

}