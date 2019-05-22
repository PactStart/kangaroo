package io.github.pactstart.system.dao;

import io.github.pactstart.basedao.MyMapper;
import io.github.pactstart.system.entity.SysDept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDeptMapper extends MyMapper<SysDept> {

    int countByNameAndParentId(@Param("parentId") Integer parentId, @Param("name") String name, @Param("id") Integer id);

    void batchUpdateLevel(@Param("deptList") List<SysDept> sysDeptList);

    int countByParentId(@Param("deptId") int deptId);

    List<SysDept> getChildDeptListByLevel(@Param("level") String level);
}