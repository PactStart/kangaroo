package io.github.pactstart.system.service.impl;

import com.google.common.collect.Lists;
import io.github.pactstart.biz.common.dto.OperateDto;
import io.github.pactstart.biz.common.utils.CollectionsUtils;
import io.github.pactstart.system.dao.SysRoleUserMapper;
import io.github.pactstart.system.dao.SysUserMapper;
import io.github.pactstart.system.dto.RoleUserListDto;
import io.github.pactstart.system.entity.SysRole;
import io.github.pactstart.system.entity.SysRoleUser;
import io.github.pactstart.system.entity.SysUser;
import io.github.pactstart.system.service.SysLogService;
import io.github.pactstart.system.service.SysRoleUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysRoleUserServiceImpl implements SysRoleUserService {

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysLogService sysLogService;

    @Override
    public List<SysUser> getListByRoleId(int roleId) {
        List<Integer> userIdList = sysRoleUserMapper.getUserIdListByRoleId(roleId);
        if (CollectionUtils.isEmpty(userIdList)) {
            return Lists.newArrayList();
        }
        return sysUserMapper.getByIdList(userIdList);
    }

    @Override
    public List<SysUser> getUserListByRoleList(List<SysRole> roleList) {
        if (CollectionUtils.isEmpty(roleList)) {
            return Lists.newArrayList();
        }
        List<Integer> roleIdList = roleList.stream().map(role -> role.getId()).collect(Collectors.toList());
        List<Integer> userIdList = sysRoleUserMapper.getUserIdListByRoleIdList(roleIdList);
        if (CollectionUtils.isEmpty(userIdList)) {
            return Lists.newArrayList();
        }
        return sysUserMapper.getByIdList(userIdList);
    }

    @Transactional
    @Override
    public void changeRoleUsers(RoleUserListDto roleUserListDto) {
        Integer roleId = roleUserListDto.getRoleId();
        List<Integer> userIdList = roleUserListDto.getUserList();

        List<Integer> originUserIdList = sysRoleUserMapper.getUserIdListByRoleId(roleId);
        //验证拥有此角色的用户有无变化，没有变化直接返回
        if (CollectionsUtils.equals(originUserIdList, userIdList)) {
            return;
        }
        updateRoleUsers(roleId, userIdList, roleUserListDto);
        sysLogService.saveRoleUserLog(roleId, originUserIdList, userIdList, roleUserListDto);
    }

    private void updateRoleUsers(int roleId, List<Integer> userIdList, OperateDto operateDto) {
        sysRoleUserMapper.deleteByRoleId(roleId);

        if (CollectionUtils.isEmpty(userIdList)) {
            return;
        }
        List<SysRoleUser> roleUserList = Lists.newArrayList();
        for (Integer userId : userIdList) {
            SysRoleUser roleUser = SysRoleUser.builder().roleId(roleId).userId(userId).operator(operateDto.getOperator())
                    .operateIp(operateDto.getOperateIp()).operateTime(new Date()).build();
            roleUserList.add(roleUser);
        }
        sysRoleUserMapper.insertList(roleUserList);
    }
}
