package io.github.pactstart.system.service;

import io.github.pactstart.biz.common.dto.IdOperateDto;
import io.github.pactstart.biz.common.dto.OperateDto;
import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.system.dto.LogQueryDto;
import io.github.pactstart.system.dto.SysLogDto;
import io.github.pactstart.system.entity.*;

import java.util.List;
import java.util.Set;

public interface SysLogService {

    void recover(IdOperateDto idOperateDto);

    PageResultDto<SysLogDto> query(LogQueryDto logQueryDto);

    void saveUserLog(SysUser before, SysUser after);

    void saveDeptLog(SysDept before, SysDept after);

    void saveAclModuleLog(SysAclModule before, SysAclModule after);

    void saveAclLog(SysAcl before, SysAcl after);

    void saveRoleAclLog(Integer roleId, List<Integer> before, Set<Integer> after, OperateDto operateDto);

    void saveRoleLog(SysRole before, SysRole after);

    void saveRoleUserLog(Integer roleId, List<Integer> before, List<Integer> after, OperateDto operateDto);

}
