package io.github.pactstart.system.service;

import io.github.pactstart.biz.common.dto.IdDto;
import io.github.pactstart.system.dto.SysRoleDto;
import io.github.pactstart.system.entity.SysRole;

import java.util.List;

public interface SysRoleService {

    /**
     * 创建角色
     *
     * @param sysRoleDto
     */
    void add(SysRoleDto sysRoleDto);

    /**
     * 修改角色
     *
     * @param sysRoleDto
     */
    void update(SysRoleDto sysRoleDto);

    /**
     * 删除角色
     *
     * @param idDto
     */
    void delete(IdDto idDto);

    /**
     * 获取所有的角色
     *
     * @return
     */
    List<SysRole> getAll();

    /**
     * 获取用户的所有角色
     *
     * @param userId
     * @return
     */
    List<SysRole> getRoleListByUserId(int userId);

    /**
     * 获取拥有某个权限点的所有角色
     *
     * @param aclId
     * @return
     */
    List<SysRole> getRoleListByAclId(int aclId);

}
