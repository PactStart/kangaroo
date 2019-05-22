package io.github.pactstart.system.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import io.github.pactstart.biz.common.dto.OperateDto;
import io.github.pactstart.system.dao.SysRoleAclMapper;
import io.github.pactstart.system.dto.RoleAclListDto;
import io.github.pactstart.system.entity.SysRoleAcl;
import io.github.pactstart.system.service.SysLogService;
import io.github.pactstart.system.service.SysRoleAclService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class SysRoleAclServiceImpl implements SysRoleAclService {

    @Autowired
    private SysRoleAclMapper sysRoleAclMapper;

    @Autowired
    private SysLogService sysLogService;

    @Transactional

    @Override
    public void changeRoleAcls(RoleAclListDto roleAclListDto) {
        Integer roleId = roleAclListDto.getRoleId();
        Set<Integer> aclIdSet = Sets.newHashSet();
        aclIdSet.addAll(roleAclListDto.getAclList());

        List<Integer> originAclIdList = sysRoleAclMapper.getAclIdListByRoleIdList(Lists.newArrayList(roleId));
        //验证角色拥有的权限点有无变化，没有变化直接返回
        boolean hasChange = true;
        if (originAclIdList != null && originAclIdList.size() == originAclIdList.size()) {
            for (int i = 0; i < originAclIdList.size(); i++) {
                if (!aclIdSet.contains(originAclIdList.get(i))) {
                    hasChange = false;
                }
            }
        }
        if (hasChange) {
            updateRoleAcls(roleId, aclIdSet, roleAclListDto);
            sysLogService.saveRoleAclLog(roleId, originAclIdList, aclIdSet, roleAclListDto);
        }
    }

    private void updateRoleAcls(int roleId, Set<Integer> aclIdList, OperateDto operateDto) {
        sysRoleAclMapper.deleteByRoleId(roleId);

        if (CollectionUtils.isEmpty(aclIdList)) {
            return;
        }
        List<SysRoleAcl> roleAclList = Lists.newArrayList();
        for (Integer aclId : aclIdList) {
            SysRoleAcl roleAcl = SysRoleAcl.builder().roleId(roleId).aclId(aclId)
                    .operator(operateDto.getOperator()).operateIp(operateDto.getOperateIp()).operateTime(new Date()).build();
            roleAclList.add(roleAcl);
        }
        sysRoleAclMapper.batchInsert(roleAclList);
    }
}
