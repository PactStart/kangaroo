package io.github.pactstart.system.service.impl;

import io.github.pactstart.biz.common.dto.IdDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import io.github.pactstart.biz.common.utils.LevelUtil;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.system.dao.SysAclMapper;
import io.github.pactstart.system.dao.SysAclModuleMapper;
import io.github.pactstart.system.dto.SysAclModuleDto;
import io.github.pactstart.system.entity.SysAclModule;
import io.github.pactstart.system.service.SysAclModuleService;
import io.github.pactstart.system.service.SysLogService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysAclModuleServiceImpl implements SysAclModuleService {

    @Resource
    private SysAclModuleMapper sysAclModuleMapper;

    @Resource
    private SysAclMapper sysAclMapper;

    @Resource
    private SysLogService sysLogService;

    @Override
    public void add(SysAclModuleDto sysAclModuleDto) {
        if (checkExist(sysAclModuleDto.getParentId(), sysAclModuleDto.getName(), sysAclModuleDto.getId())) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "同一层级下存在相同名称的权限模块");
        }
        SysAclModule aclModule = SysAclModule.builder().name(sysAclModuleDto.getName()).parentId(sysAclModuleDto.getParentId())
                .seq(sysAclModuleDto.getSeq()).status(sysAclModuleDto.getStatus()).remark(sysAclModuleDto.getRemark())
                .operator(sysAclModuleDto.getOperator()).operateIp(sysAclModuleDto.getOperateIp()).build();
        aclModule.setLevel(LevelUtil.calculateLevel(getLevel(sysAclModuleDto.getParentId()), sysAclModuleDto.getParentId()));
        aclModule.setOperateTime(new Date());
        sysAclModuleMapper.insertSelective(aclModule);
        sysLogService.saveAclModuleLog(null, aclModule);
    }

    @Override
    public void update(SysAclModuleDto sysAclModuleDto) {
        if (checkExist(sysAclModuleDto.getParentId(), sysAclModuleDto.getName(), sysAclModuleDto.getId())) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "同一层级下存在相同名称的权限模块");
        }
        SysAclModule before = sysAclModuleMapper.selectByPrimaryKey(sysAclModuleDto.getId());
        if (before == null) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "待更新的权限模块不存在");
        }
        SysAclModule after = SysAclModule.builder().id(sysAclModuleDto.getId()).name(sysAclModuleDto.getName()).parentId(sysAclModuleDto.getParentId())
                .seq(sysAclModuleDto.getSeq()).status(sysAclModuleDto.getStatus()).remark(sysAclModuleDto.getRemark())
                .operator(sysAclModuleDto.getOperator()).operateIp(sysAclModuleDto.getOperateIp()).operateTime(new Date()).build();
        after.setLevel(LevelUtil.calculateLevel(getLevel(sysAclModuleDto.getParentId()), sysAclModuleDto.getParentId()));
        sysAclModuleMapper.updateByPrimaryKeySelective(after);
        updateWithChild(before, after);
        sysLogService.saveAclModuleLog(before, after);
    }

    @Override
    public void delete(IdDto idDto) {
        SysAclModule aclModule = sysAclModuleMapper.selectByPrimaryKey(idDto.getId());
        if (aclModule == null) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "待删除的权限模块不存在，无法删除");
        }
        if (sysAclModuleMapper.countByParentId(aclModule.getId()) > 0) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "当前模块下面有子模块，无法删除");
        }
        if (sysAclMapper.countByAclModuleId(aclModule.getId()) > 0) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "当前模块下面有用户，无法删除");
        }
        sysAclModuleMapper.deleteByPrimaryKey(idDto.getId());
    }

    @Override
    public List<SysAclModuleDto> selectAll() {
        List<SysAclModule> sysAclModuleList = sysAclModuleMapper.selectAll();
        return MapperUtils.mapList(sysAclModuleList, SysAclModuleDto.class);
    }

    private String getLevel(Integer aclModuleId) {
        SysAclModule aclModule = sysAclModuleMapper.selectByPrimaryKey(aclModuleId);
        if (aclModule == null) {
            return null;
        }
        return aclModule.getLevel();
    }

    private boolean checkExist(Integer parentId, String aclModuleName, Integer deptId) {
        return sysAclModuleMapper.countByNameAndParentId(parentId, aclModuleName, deptId) > 0;
    }

    private void updateWithChild(SysAclModule before, SysAclModule after) {
        String newLevelPrefix = after.getLevel();
        String oldLevelPrefix = before.getLevel();
        if (!after.getLevel().equals(before.getLevel())) {
            List<SysAclModule> aclModuleList = sysAclModuleMapper.getChildAclModuleListByLevel(before.getLevel(), before.getParentId());
            if (CollectionUtils.isNotEmpty(aclModuleList)) {
                for (SysAclModule aclModule : aclModuleList) {
                    String level = aclModule.getLevel();
                    if (level.indexOf(oldLevelPrefix) == 0) {
                        level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                        aclModule.setLevel(level);
                    }
                }
                sysAclModuleMapper.batchUpdateLevel(aclModuleList);
            }
        }
        sysAclModuleMapper.updateByPrimaryKeySelective(after);
    }

}
