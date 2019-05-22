package io.github.pactstart.system.dao;

import io.github.pactstart.basedao.MyMapper;
import io.github.pactstart.system.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysUserMapper extends MyMapper<SysUser> {

    int countByTelephone(@Param("telephone") String telephone, @Param("id") Integer id);

    int countByMail(@Param("mail") String mail, @Param("id") Integer id);

    int countByDeptId(@Param("deptId") int deptId);

    SysUser findByKeyword(@Param("keyword") String keyword);

    List<SysUser> getByIdList(@Param("idList") List<Integer> idList);

    List<SysUser> query(Map<String, Object> condition);
}