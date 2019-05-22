package io.github.pactstart.system.service.impl;

import com.google.common.collect.Lists;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.system.dao.SysAclMapper;
import io.github.pactstart.system.dao.SysRoleAclMapper;
import io.github.pactstart.system.dao.SysRoleUserMapper;
import io.github.pactstart.system.dto.SysAclDto;
import io.github.pactstart.system.dto.UserIdDto;
import io.github.pactstart.system.entity.SysAcl;
import io.github.pactstart.system.service.SysCoreService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SysCoreServiceImpl implements SysCoreService {

    @Resource
    private SysAclMapper sysAclMapper;

    @Resource
    private SysRoleUserMapper sysRoleUserMapper;

    @Resource
    private SysRoleAclMapper sysRoleAclMapper;

    public List<SysAcl> getUserAclList(int userId) {
        if (isSuperAdmin(userId)) {
            return sysAclMapper.getAll();
        }
        //获取用户的所有角色
        List<Integer> userRoleIdList = sysRoleUserMapper.getRoleIdListByUserId(userId);
        if (CollectionUtils.isEmpty(userRoleIdList)) {
            return Lists.newArrayList();
        }
        //获取用户的所有权限
        List<Integer> userAclIdList = sysRoleAclMapper.getAclIdListByRoleIdList(userRoleIdList);
        if (CollectionUtils.isEmpty(userAclIdList)) {
            return Lists.newArrayList();
        }
        return sysAclMapper.getByIdList(userAclIdList);
    }

    @Override
    public List<SysAclDto> getUserAclList(UserIdDto userIdDto) {
        return MapperUtils.mapList(getUserAclList(userIdDto.getUserId()), SysAclDto.class);
    }

    @Override
    public List<SysAcl> getRoleAclList(Integer roleId) {
        List<Integer> aclIdList = sysRoleAclMapper.getAclIdListByRoleIdList(Lists.<Integer>newArrayList(roleId));
        if (CollectionUtils.isEmpty(aclIdList)) {
            return Lists.newArrayList();
        }
        return sysAclMapper.getByIdList(aclIdList);
    }

    public boolean hasUrlAcl(int userId, String url) {
        if (isSuperAdmin(userId)) {
            return true;
        }
        List<SysAcl> aclList = sysAclMapper.getByUrl(url);
        if (CollectionUtils.isEmpty(aclList)) {
            return true;
        }

        List<SysAcl> userAclList = getUserAclList(userId);
        Set<Integer> userAclIdSet = userAclList.stream().map(acl -> acl.getId()).collect(Collectors.toSet());

        boolean hasValidAcl = false;
        // 规则：只要有一个权限点有权限，那么我们就认为有访问权限
        for (SysAcl acl : aclList) {
            // 判断一个用户是否具有某个权限点的访问权限
            if (acl == null || acl.getStatus() != 1) { // 权限点无效
                continue;
            }
            hasValidAcl = true;
            if (userAclIdSet.contains(acl.getId())) {
                return true;
            }
        }
        if (!hasValidAcl) {
            return true;
        }
        return false;
    }

    private boolean isSuperAdmin(int userId) {
        // 这里是我自己定义了一个假的超级管理员规则，实际中要根据项目进行修改
        // 可以是配置文件获取，可以指定某个用户，也可以指定某个角色
        return true;
    }
}
