package io.github.pactstart.system.dao;

import io.github.pactstart.basedao.MyMapper;
import io.github.pactstart.system.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper extends MyMapper<SysRole> {

    int countByName(@Param("name") String name, @Param("id") Integer id);

    List<SysRole> getByIdList(@Param("idList") List<Integer> idList);
}