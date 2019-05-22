package io.github.pactstart.system.service;

import io.github.pactstart.system.dto.adapt.SysAclModuleAdaptDto;
import io.github.pactstart.system.dto.adapt.SysDeptAdaptDto;

import java.util.List;

public interface SysTreeService {

    List<SysAclModuleAdaptDto> roleTree(Integer roleId, Integer userId);

    List<SysAclModuleAdaptDto> userAclTree(int userId);

    List<SysAclModuleAdaptDto> roleAclTree(Integer roleId);

    List<SysAclModuleAdaptDto> aclModuleTree();

    List<SysDeptAdaptDto> deptTree();

}
