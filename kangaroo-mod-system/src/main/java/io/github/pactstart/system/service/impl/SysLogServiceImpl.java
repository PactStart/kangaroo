package io.github.pactstart.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.github.pactstart.biz.common.dto.IdOperateDto;
import io.github.pactstart.biz.common.dto.OperateDto;
import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import io.github.pactstart.biz.common.utils.PageUtils;
import io.github.pactstart.commonutils.JsonUtils;
import io.github.pactstart.system.constans.LogTypeConstants;
import io.github.pactstart.system.dao.*;
import io.github.pactstart.system.dto.LogQueryDto;
import io.github.pactstart.system.dto.RoleAclListDto;
import io.github.pactstart.system.dto.RoleUserListDto;
import io.github.pactstart.system.dto.SysLogDto;
import io.github.pactstart.system.entity.*;
import io.github.pactstart.system.enums.SysLogStatus;
import io.github.pactstart.system.service.SysLogService;
import io.github.pactstart.system.service.SysRoleAclService;
import io.github.pactstart.system.service.SysRoleUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Resource
    private SysLogMapper sysLogMapper;
    @Resource
    private SysDeptMapper sysDeptMapper;
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysAclModuleMapper sysAclModuleMapper;
    @Resource
    private SysAclMapper sysAclMapper;
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysRoleAclService sysRoleAclService;
    @Resource
    private SysRoleUserService sysRoleUserService;

    @Transactional
    @Override
    public void recover(IdOperateDto idOperateDto) {
        SysLog sysLog = sysLogMapper.selectByPrimaryKey(idOperateDto.getId());
        if (sysLog == null) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "待还原的记录不存在");
        }
        if (SysLogStatus.valueOf(sysLog.getStatus()) != SysLogStatus.UN_RESTORE) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "记录非未还原状态");
        }
        switch (sysLog.getType()) {
            case LogTypeConstants.TYPE_DEPT:
                recoverDept(sysLog, idOperateDto);
                break;
            case LogTypeConstants.TYPE_USER:
                recoverUser(sysLog, idOperateDto);
                break;
            case LogTypeConstants.TYPE_ACL_MODULE:
                recoverAclModule(sysLog, idOperateDto);
                break;
            case LogTypeConstants.TYPE_ACL:
                recoverAcl(sysLog, idOperateDto);
                break;
            case LogTypeConstants.TYPE_ROLE:
                recoverRole(sysLog, idOperateDto);
                break;
            case LogTypeConstants.TYPE_ROLE_ACL:
                recoverRoleAcl(sysLog, idOperateDto);
                break;
            case LogTypeConstants.TYPE_ROLE_USER:
                recoverRoleUser(sysLog, idOperateDto);
                break;
            default:
                ;
        }
        sysLog.setStatus(SysLogStatus.RESTORE.getValue());
        sysLogMapper.updateByPrimaryKeySelective(sysLog);
    }

    @Override
    public PageResultDto<SysLogDto> query(LogQueryDto logQueryDto) {
        Page<SysLog> page = PageHelper.startPage(logQueryDto.getPageNum(), logQueryDto.getPageSize()).doSelectPage(() -> sysLogMapper.query(logQueryDto));
        return PageUtils.convert(page, SysLogDto.class);
    }

    public void saveUserLog(SysUser before, SysUser after) {
        SysLog sysLog = new SysLog();
        sysLog.setType(LogTypeConstants.TYPE_USER);
        sysLog.setTargetId(after == null ? before.getId() : after.getId());
        sysLog.setOldValue(before == null ? "" : JsonUtils.obj2String(before));
        sysLog.setNewValue(after == null ? "" : JsonUtils.obj2String(after));
        sysLog.setOperator(after.getOperator());
        sysLog.setOperateIp(after.getOperateIp());
        sysLog.setOperateTime(new Date());
        sysLog.setStatus(SysLogStatus.UN_RESTORE.getValue());
        sysLogMapper.insertSelective(sysLog);
    }

    public void saveDeptLog(SysDept before, SysDept after) {
        SysLog sysLog = new SysLog();
        sysLog.setType(LogTypeConstants.TYPE_DEPT);
        sysLog.setTargetId(after == null ? before.getId() : after.getId());
        sysLog.setOldValue(before == null ? "" : JsonUtils.obj2String(before));
        sysLog.setNewValue(after == null ? "" : JsonUtils.obj2String(after));
        sysLog.setOperator(after.getOperator());
        sysLog.setOperateIp(after.getOperateIp());
        sysLog.setOperateTime(new Date());
        sysLog.setStatus(SysLogStatus.UN_RESTORE.getValue());
        sysLogMapper.insertSelective(sysLog);
    }

    @Override
    public void saveAclModuleLog(SysAclModule before, SysAclModule after) {
        SysLog sysLog = new SysLog();
        sysLog.setType(LogTypeConstants.TYPE_ACL_MODULE);
        sysLog.setTargetId(after == null ? before.getId() : after.getId());
        sysLog.setOldValue(before == null ? "" : JsonUtils.obj2String(before));
        sysLog.setNewValue(after == null ? "" : JsonUtils.obj2String(after));
        sysLog.setOperator(after.getOperator());
        sysLog.setOperateIp(after.getOperateIp());
        sysLog.setOperateTime(new Date());
        sysLog.setStatus(SysLogStatus.UN_RESTORE.getValue());
        sysLogMapper.insertSelective(sysLog);
    }

    @Override
    public void saveAclLog(SysAcl before, SysAcl after) {
        SysLog sysLog = new SysLog();
        sysLog.setType(LogTypeConstants.TYPE_ACL);
        sysLog.setTargetId(after == null ? before.getId() : after.getId());
        sysLog.setOldValue(before == null ? "" : JsonUtils.obj2String(before));
        sysLog.setNewValue(after == null ? "" : JsonUtils.obj2String(after));
        sysLog.setOperator(after.getOperator());
        sysLog.setOperateIp(after.getOperateIp());
        sysLog.setOperateTime(new Date());
        sysLog.setStatus(SysLogStatus.UN_RESTORE.getValue());
        sysLogMapper.insertSelective(sysLog);
    }

    @Override
    public void saveRoleAclLog(Integer roleId, List<Integer> before, Set<Integer> after, OperateDto operateDto) {
        SysLog sysLog = new SysLog();
        sysLog.setType(LogTypeConstants.TYPE_ROLE_ACL);
        sysLog.setTargetId(roleId);
        sysLog.setOldValue(before == null ? "" : JsonUtils.obj2String(before));
        sysLog.setNewValue(after == null ? "" : JsonUtils.obj2String(after));
        sysLog.setOperator(operateDto.getOperator());
        sysLog.setOperateIp(operateDto.getOperateIp());
        sysLog.setOperateTime(new Date());
        sysLog.setStatus(SysLogStatus.UN_RESTORE.getValue());
        sysLogMapper.insertSelective(sysLog);
    }

    @Override
    public void saveRoleLog(SysRole before, SysRole after) {
        SysLog sysLog = new SysLog();
        sysLog.setType(LogTypeConstants.TYPE_ROLE);
        sysLog.setTargetId(after == null ? before.getId() : after.getId());
        sysLog.setOldValue(before == null ? "" : JsonUtils.obj2String(before));
        sysLog.setNewValue(after == null ? "" : JsonUtils.obj2String(after));
        sysLog.setOperator(after.getOperator());
        sysLog.setOperateIp(after.getOperateIp());
        sysLog.setOperateTime(new Date());
        sysLog.setStatus(SysLogStatus.UN_RESTORE.getValue());
        sysLogMapper.insertSelective(sysLog);
    }

    @Override
    public void saveRoleUserLog(Integer roleId, List<Integer> before, List<Integer> after, OperateDto operateDto) {
        SysLog sysLog = new SysLog();
        sysLog.setType(LogTypeConstants.TYPE_ROLE_USER);
        sysLog.setTargetId(roleId);
        sysLog.setOldValue(before == null ? "" : JsonUtils.obj2String(before));
        sysLog.setNewValue(after == null ? "" : JsonUtils.obj2String(after));
        sysLog.setOperator(operateDto.getOperator());
        sysLog.setOperateIp(operateDto.getOperateIp());
        sysLog.setOperateTime(new Date());
        sysLog.setStatus(SysLogStatus.UN_RESTORE.getValue());
        sysLogMapper.insertSelective(sysLog);
    }


    private void recoverDept(SysLog sysLog, IdOperateDto operateDto) {
        SysDept beforeDept = sysDeptMapper.selectByPrimaryKey(sysLog.getTargetId());
        if (beforeDept == null) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "待还原的部门已经不存在了");
        }
        if (StringUtils.isBlank(sysLog.getNewValue()) || StringUtils.isBlank(sysLog.getOldValue())) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "新增和删除操作不做还原");
        }
        SysDept afterDept = JsonUtils.string2Obj(sysLog.getOldValue(), SysDept.class);
        afterDept.setOperator(operateDto.getOperator());
        afterDept.setOperateIp(operateDto.getOperateIp());
        afterDept.setOperateTime(new Date());
        sysDeptMapper.updateByPrimaryKeySelective(afterDept);
        saveDeptLog(beforeDept, afterDept);
    }

    private void recoverUser(SysLog sysLog, IdOperateDto operateDto) {
        SysUser beforeUser = sysUserMapper.selectByPrimaryKey(sysLog.getTargetId());
        if (beforeUser == null) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "待还原的用户已经不存在了");
        }
        if (StringUtils.isBlank(sysLog.getNewValue()) || StringUtils.isBlank(sysLog.getOldValue())) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "新增和删除操作不做还原");
        }
        SysUser afterUser = JsonUtils.string2Obj(sysLog.getOldValue(), SysUser.class);
        afterUser.setOperator(operateDto.getOperator());
        afterUser.setOperateIp(operateDto.getOperateIp());
        afterUser.setOperateTime(new Date());
        sysUserMapper.updateByPrimaryKeySelective(afterUser);
        saveUserLog(beforeUser, afterUser);
    }

    private void recoverAclModule(SysLog sysLog, IdOperateDto operateDto) {
        SysAclModule beforeAclModule = sysAclModuleMapper.selectByPrimaryKey(sysLog.getTargetId());
        if (beforeAclModule == null) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "待还原的权限模块已经不存在了");
        }
        if (StringUtils.isBlank(sysLog.getNewValue()) || StringUtils.isBlank(sysLog.getOldValue())) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "新增和删除操作不做还原");
        }
        SysAclModule afterAclModule = JsonUtils.string2Obj(sysLog.getOldValue(), SysAclModule.class);
        afterAclModule.setOperator(operateDto.getOperator());
        afterAclModule.setOperateIp(operateDto.getOperateIp());
        afterAclModule.setOperateTime(new Date());
        sysAclModuleMapper.updateByPrimaryKeySelective(afterAclModule);
        saveAclModuleLog(beforeAclModule, afterAclModule);
    }

    private void recoverAcl(SysLog sysLog, IdOperateDto operateDto) {
        SysAcl beforeAcl = sysAclMapper.selectByPrimaryKey(sysLog.getTargetId());
        if (beforeAcl == null) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "待还原的权限点已经不存在了");
        }
        if (StringUtils.isBlank(sysLog.getNewValue()) || StringUtils.isBlank(sysLog.getOldValue())) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "新增和删除操作不做还原");
        }
        SysAcl afterAcl = JsonUtils.string2Obj(sysLog.getOldValue(), SysAcl.class);
        afterAcl.setOperator(operateDto.getOperator());
        afterAcl.setOperateIp(operateDto.getOperateIp());
        afterAcl.setOperateTime(new Date());
        sysAclMapper.updateByPrimaryKeySelective(afterAcl);
        saveAclLog(beforeAcl, afterAcl);
    }

    private void recoverRole(SysLog sysLog, IdOperateDto operateDto) {
        SysRole beforeRole = sysRoleMapper.selectByPrimaryKey(sysLog.getTargetId());
        if (beforeRole == null) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "待还原的角色已经不存在了");
        }
        if (StringUtils.isBlank(sysLog.getNewValue()) || StringUtils.isBlank(sysLog.getOldValue())) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "新增和删除操作不做还原");
        }
        SysRole afterRole = JsonUtils.string2Obj(sysLog.getOldValue(), SysRole.class);
        afterRole.setOperator(operateDto.getOperator());
        afterRole.setOperateIp(operateDto.getOperateIp());
        afterRole.setOperateTime(new Date());
        sysRoleMapper.updateByPrimaryKeySelective(afterRole);
        saveRoleLog(beforeRole, afterRole);
    }

    private void recoverRoleAcl(SysLog sysLog, IdOperateDto operateDto) {
        SysRole role = sysRoleMapper.selectByPrimaryKey(sysLog.getTargetId());
        if (role == null) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "角色已经不存在了");
        }
        RoleAclListDto roleAclListDto = new RoleAclListDto();
        roleAclListDto.setAclList(JsonUtils.string2List(sysLog.getOldValue(), Integer.class));
        roleAclListDto.setRoleId(sysLog.getTargetId());
        roleAclListDto.setOperator(operateDto.getOperator());
        roleAclListDto.setOperateIp(operateDto.getOperateIp());
        sysRoleAclService.changeRoleAcls(roleAclListDto);
    }

    private void recoverRoleUser(SysLog sysLog, IdOperateDto operateDto) {
        SysRole userRole = sysRoleMapper.selectByPrimaryKey(sysLog.getTargetId());
        if (userRole == null) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "角色已经不存在了");
        }
        RoleUserListDto roleUserListDto = new RoleUserListDto();
        roleUserListDto.setUserList(JsonUtils.string2List(sysLog.getOldValue(), Integer.class));
        roleUserListDto.setRoleId(sysLog.getTargetId());
        roleUserListDto.setOperator(operateDto.getOperator());
        roleUserListDto.setOperateIp(operateDto.getOperateIp());
        sysRoleUserService.changeRoleUsers(roleUserListDto);
    }
}
