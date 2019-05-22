package io.github.pactstart.system.service;

import io.github.pactstart.system.dto.RoleAclListDto;

public interface SysRoleAclService {

    /**
     * 修改角色拥有的权限
     *
     * @param roleAclListDto
     */
    void changeRoleAcls(RoleAclListDto roleAclListDto);
}
