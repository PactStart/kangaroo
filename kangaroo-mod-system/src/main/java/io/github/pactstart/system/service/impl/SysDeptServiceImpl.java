package io.github.pactstart.system.service.impl;

import io.github.pactstart.biz.common.dto.IdDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import io.github.pactstart.biz.common.utils.LevelUtil;
import io.github.pactstart.system.dao.SysDeptMapper;
import io.github.pactstart.system.dao.SysUserMapper;
import io.github.pactstart.system.dto.SysDeptDto;
import io.github.pactstart.system.entity.SysDept;
import io.github.pactstart.system.service.SysDeptService;
import io.github.pactstart.system.service.SysLogService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Resource
    private SysDeptMapper sysDeptMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysLogService sysLogService;

    @Transactional
    @Override
    public void add(SysDeptDto sysDeptDto) {
        if (checkExist(sysDeptDto.getParentId(), sysDeptDto.getName(), sysDeptDto.getId())) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "同一层级下存在相同名称的部门");
        }
        SysDept dept = SysDept.builder().name(sysDeptDto.getName()).parentId(sysDeptDto.getParentId())
                .seq(sysDeptDto.getSeq()).remark(sysDeptDto.getRemark())
                .operator(sysDeptDto.getOperator()).operateIp(sysDeptDto.getOperateIp()).operateTime(new Date()).build();
        dept.setLevel(LevelUtil.calculateLevel(getLevel(sysDeptDto.getParentId()), sysDeptDto.getParentId()));
        sysDeptMapper.insertSelective(dept);
        sysLogService.saveDeptLog(null, dept);
    }

    @Override
    public void update(SysDeptDto sysDeptDto) {
        if (sysDeptDto.getId() == 0) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "不能修改默认部门");
        }
        if (checkExist(sysDeptDto.getParentId(), sysDeptDto.getName(), sysDeptDto.getId())) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "同一层级下存在相同名称的部门");
        }
        SysDept before = sysDeptMapper.selectByPrimaryKey(sysDeptDto.getId());
        if (before == null) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "待更新的部门不存在");
        }
        SysDept after = SysDept.builder().id(sysDeptDto.getId()).name(sysDeptDto.getName()).parentId(sysDeptDto.getParentId())
                .seq(sysDeptDto.getSeq()).remark(sysDeptDto.getRemark())
                .operator(sysDeptDto.getOperator()).operateIp(sysDeptDto.getOperateIp()).operateTime(new Date()).build();
        after.setLevel(LevelUtil.calculateLevel(getLevel(sysDeptDto.getParentId()), sysDeptDto.getParentId()));

        updateWithChild(before, after);
        sysLogService.saveDeptLog(before, after);
    }

    @Override
    public void delete(IdDto idDto) {
        SysDept dept = sysDeptMapper.selectByPrimaryKey(idDto.getId());
        if (idDto.getId() == 0) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "默认部门不能删除");
        }
        if (dept == null) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "待删除的部门不存在，无法删除");
        }
        if (sysDeptMapper.countByParentId(dept.getId()) > 0) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "当前部门下面有子部门，无法删除");
        }
        if (sysUserMapper.countByDeptId(dept.getId()) > 0) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "当前部门下面有用户，无法删除");
        }
        sysDeptMapper.deleteByPrimaryKey(idDto.getId());
    }

    private boolean checkExist(Integer parentId, String deptName, Integer deptId) {
        return sysDeptMapper.countByNameAndParentId(parentId, deptName, deptId) > 0;
    }

    private String getLevel(Integer deptId) {
        SysDept dept = sysDeptMapper.selectByPrimaryKey(deptId);
        if (dept == null) {
            return null;
        }
        return dept.getLevel();
    }

    private void updateWithChild(SysDept before, SysDept after) {
        String newLevelPrefix = after.getLevel();
        String oldLevelPrefix = before.getLevel();
        if (!after.getLevel().equals(before.getLevel())) {
            List<SysDept> deptList = sysDeptMapper.getChildDeptListByLevel(before.getLevel());
            if (CollectionUtils.isNotEmpty(deptList)) {
                for (SysDept dept : deptList) {
                    String level = dept.getLevel();
                    if (level.indexOf(oldLevelPrefix) == 0) {
                        level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                        dept.setLevel(level);
                    }
                }
                sysDeptMapper.batchUpdateLevel(deptList);
            }
        }
        sysDeptMapper.updateByPrimaryKey(after);
    }
}
