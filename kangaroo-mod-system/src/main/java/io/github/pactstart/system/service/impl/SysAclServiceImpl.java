package io.github.pactstart.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.github.pactstart.biz.common.dto.IdDto;
import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import io.github.pactstart.biz.common.utils.PageUtils;
import io.github.pactstart.system.dao.SysAclMapper;
import io.github.pactstart.system.dto.AclQueryDto;
import io.github.pactstart.system.dto.SysAclDto;
import io.github.pactstart.system.entity.SysAcl;
import io.github.pactstart.system.service.SysAclService;
import io.github.pactstart.system.service.SysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SysAclServiceImpl implements SysAclService {

    @Resource
    private SysAclMapper sysAclMapper;

    @Resource
    private SysLogService sysLogService;

    @Override
    public void add(SysAclDto sysAclDto) {
        if (checkExist(sysAclDto.getAclModuleId(), sysAclDto.getName(), sysAclDto.getId())) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "当前权限模块下面存在相同名称的权限点");
        }
        SysAcl acl = SysAcl.builder().name(sysAclDto.getName()).aclModuleId(sysAclDto.getAclModuleId()).url(sysAclDto.getUrl())
                .type(sysAclDto.getType()).status(sysAclDto.getStatus()).seq(sysAclDto.getSeq()).remark(sysAclDto.getRemark())
                .operator(sysAclDto.getOperator()).operateIp(sysAclDto.getOperateIp()).operateTime(new Date()).build();
        acl.setCode(generateCode());

        sysAclMapper.insertSelective(acl);
        sysLogService.saveAclLog(null, acl);
    }

    @Override
    public void update(SysAclDto sysAclDto) {
        if (checkExist(sysAclDto.getAclModuleId(), sysAclDto.getName(), sysAclDto.getId())) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "当前权限模块下面存在相同名称的权限点");
        }
        SysAcl before = sysAclMapper.selectByPrimaryKey(sysAclDto.getId());
        if (before == null) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "待更新的权限点不存在");
        }
        SysAcl after = SysAcl.builder().id(sysAclDto.getId()).name(sysAclDto.getName()).aclModuleId(sysAclDto.getAclModuleId()).url(sysAclDto.getUrl())
                .type(sysAclDto.getType()).status(sysAclDto.getStatus()).seq(sysAclDto.getSeq()).remark(sysAclDto.getRemark())
                .operator(sysAclDto.getOperator()).operateIp(sysAclDto.getOperateIp()).operateTime(new Date()).build();

        sysAclMapper.updateByPrimaryKeySelective(after);
        sysLogService.saveAclLog(before, after);
    }

    @Override
    public void delete(IdDto idDto) {
        SysAcl sysAcl = sysAclMapper.selectByPrimaryKey(idDto.getId());
        if (sysAcl == null) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "待删除的权限点不存在");
        }
        sysAclMapper.deleteByPrimaryKey(sysAcl);
    }

    @Override
    public PageResultDto<SysAclDto> query(AclQueryDto aclQueryDto) {
        Page<SysAcl> page = PageHelper.startPage(aclQueryDto.getPageNum(), aclQueryDto.getPageSize()).doSelectPage(() -> sysAclMapper.query(aclQueryDto));
        return PageUtils.convert(page, SysAclDto.class);
    }

    private boolean checkExist(int aclModuleId, String name, Integer id) {
        return sysAclMapper.countByNameAndAclModuleId(aclModuleId, name, id) > 0;
    }

    public String generateCode() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(new Date()) + "_" + (int) (Math.random() * 100);
    }
}
