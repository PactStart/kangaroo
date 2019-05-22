package io.github.pactstart.system.service;

import io.github.pactstart.system.dto.RoleUserListDto;
import io.github.pactstart.system.entity.SysRole;
import io.github.pactstart.system.entity.SysUser;

import java.util.List;

public interface SysRoleUserService {

    /**
     * 获取拥有某个角色的所有用户
     *
     * @param roleId
     * @return
     */
    List<SysUser> getListByRoleId(int roleId);

    /**
     * 获取拥有一组角色中任一角色的所有用户
     *
     * @param roleList
     * @return
     */
    List<SysUser> getUserListByRoleList(List<SysRole> roleList);

    /**
     * 修改角色所属的用户列表
     *
     * @param roleUserListDto
     */
    void changeRoleUsers(RoleUserListDto roleUserListDto);
}
