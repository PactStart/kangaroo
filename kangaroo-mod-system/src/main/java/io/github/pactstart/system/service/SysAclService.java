package io.github.pactstart.system.service;

import io.github.pactstart.biz.common.dto.IdDto;
import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.system.dto.AclQueryDto;
import io.github.pactstart.system.dto.SysAclDto;

public interface SysAclService {

    /**
     * 添加权限点
     *
     * @param sysAclDto
     */
    void add(SysAclDto sysAclDto);

    /**
     * 修改权限点
     *
     * @param sysAclDto
     */
    void update(SysAclDto sysAclDto);

    /**
     * 删除权限点
     *
     * @param idDto
     */
    void delete(IdDto idDto);

    /**
     * 查询权限点
     *
     * @param aclQueryDto
     * @return
     */
    PageResultDto<SysAclDto> query(AclQueryDto aclQueryDto);

}
