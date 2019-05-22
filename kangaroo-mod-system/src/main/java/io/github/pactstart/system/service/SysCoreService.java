package io.github.pactstart.system.service;

import io.github.pactstart.system.dto.SysAclDto;
import io.github.pactstart.system.dto.UserIdDto;
import io.github.pactstart.system.entity.SysAcl;

import java.util.List;

public interface SysCoreService {

    /**
     * 获取用户的所有权限点
     *
     * @param userId
     * @return
     */
    List<SysAcl> getUserAclList(int userId);

    /**
     * 获取用户的所有权限点
     *
     * @param userIdDto
     * @return
     */
    List<SysAclDto> getUserAclList(UserIdDto userIdDto);

    /**
     * 获取角色的所有权限点
     *
     * @param roleId
     * @return
     */
    List<SysAcl> getRoleAclList(Integer roleId);

    /**
     * 判断用户是否有拥有此权限点
     *
     * @param userId
     * @param url
     * @return
     */
    boolean hasUrlAcl(int userId, String url);
}
