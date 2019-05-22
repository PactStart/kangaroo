package io.github.pactstart.system.service.impl;

import com.google.common.collect.Lists;
import io.github.pactstart.biz.common.dto.IdDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import io.github.pactstart.system.dao.SysRoleAclMapper;
import io.github.pactstart.system.dao.SysRoleMapper;
import io.github.pactstart.system.dao.SysRoleUserMapper;
import io.github.pactstart.system.dto.SysRoleDto;
import io.github.pactstart.system.entity.SysRole;
import io.github.pactstart.system.service.SysLogService;
import io.github.pactstart.system.service.SysRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    @Autowired
    private SysRoleAclMapper sysRoleAclMapper;

    @Autowired
    private SysLogService sysLogService;

    @Override
    public void add(SysRoleDto sysRoleDto) {
        if (checkExist(sysRoleDto.getName(), sysRoleDto.getId())) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "角色名称已经存在");
        }
        SysRole role = SysRole.builder().name(sysRoleDto.getName()).status(sysRoleDto.getStatus()).type(sysRoleDto.getType())
                .remark(sysRoleDto.getRemark()).operator(sysRoleDto.getOperator()).operateIp(sysRoleDto.getOperateIp()).build();
        role.setOperateTime(new Date());
        sysRoleMapper.insertSelective(role);
        sysLogService.saveRoleLog(null, role);
    }

    @Override
    public void update(SysRoleDto sysRoleDto) {
        if (checkExist(sysRoleDto.getName(), sysRoleDto.getId())) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "角色名称已经存在");
        }
        SysRole before = sysRoleMapper.selectByPrimaryKey(sysRoleDto.getId());
        if (before == null) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "您要修改的角色不存在");
        }
        SysRole after = SysRole.builder().id(before.getId()).name(sysRoleDto.getName()).status(sysRoleDto.getStatus()).type(sysRoleDto.getType())
                .remark(sysRoleDto.getRemark()).operator(sysRoleDto.getOperator()).operateIp(sysRoleDto.getOperateIp()).build();
        after.setOperateTime(new Date());
        sysRoleMapper.updateByPrimaryKeySelective(after);
        sysLogService.saveRoleLog(before, after);
    }

    @Override
    public void delete(IdDto idDto) {
        SysRole before = sysRoleMapper.selectByPrimaryKey(idDto.getId());
        if (before == null) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "您要删除的角色不存在");
        }
        if (sysRoleUserMapper.countByRoleId(idDto.getId()) > 0) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "当前角色下面有用户，无法删除");
        }
        sysRoleMapper.deleteByPrimaryKey(idDto.getId());
    }

    public List<SysRole> getAll() {
        return sysRoleMapper.selectAll();
    }

    @Override
    public List<SysRole> getRoleListByUserId(int userId) {
        List<Integer> roleIdList = sysRoleUserMapper.getRoleIdListByUserId(userId);
        if (CollectionUtils.isEmpty(roleIdList)) {
            return Lists.newArrayList();
        }
        return sysRoleMapper.getByIdList(roleIdList);
    }

    @Override
    public List<SysRole> getRoleListByAclId(int aclId) {
        List<Integer> roleIdList = sysRoleAclMapper.getRoleIdListByAclId(aclId);
        if (CollectionUtils.isEmpty(roleIdList)) {
            return Lists.newArrayList();
        }
        return sysRoleMapper.getByIdList(roleIdList);
    }

    private boolean checkExist(String name, Integer id) {
        return sysRoleMapper.countByName(name, id) > 0;
    }
}
