package io.github.pactstart.system.service;

import io.github.pactstart.biz.common.dto.IdDto;
import io.github.pactstart.system.dto.SysAclModuleDto;

import java.util.List;

public interface SysAclModuleService {

    void add(SysAclModuleDto sysAclModuleDto);

    void update(SysAclModuleDto sysAclModuleDto);

    void delete(IdDto idDto);

    List<SysAclModuleDto> selectAll();
}
