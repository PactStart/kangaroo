package io.github.pactstart.system.dao;


import io.github.pactstart.basedao.MyMapper;
import io.github.pactstart.system.entity.Config;

import java.util.List;

public interface ConfigMapper extends MyMapper<Config> {

    List<Config> query(Object object);

}