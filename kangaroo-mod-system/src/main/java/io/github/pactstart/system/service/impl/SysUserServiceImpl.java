package io.github.pactstart.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import io.github.pactstart.biz.common.utils.BeanMapUtils;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.biz.common.utils.PageUtils;
import io.github.pactstart.commonutils.DataUtils;
import io.github.pactstart.commonutils.ValidUtils;
import io.github.pactstart.system.dao.SysDeptMapper;
import io.github.pactstart.system.dao.SysUserMapper;
import io.github.pactstart.system.dto.SysUserDto;
import io.github.pactstart.system.dto.UserIdDto;
import io.github.pactstart.system.dto.UserQueryDto;
import io.github.pactstart.system.entity.SysUser;
import io.github.pactstart.system.enums.SysUserStatus;
import io.github.pactstart.system.service.SysLogService;
import io.github.pactstart.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Autowired
    private SysLogService sysLogService;

    @Transactional
    @Override
    public void add(SysUserDto sysUserDto) {
        if (checkTelephoneExist(sysUserDto.getTelephone(), sysUserDto.getId())) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "电话已被占用");
        }
        if (checkEmailExist(sysUserDto.getMail(), sysUserDto.getId())) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "邮箱已被占用");
        }
        if (sysUserDto.getDeptId() != 0 && sysDeptMapper.selectByPrimaryKey(sysUserDto.getDeptId()) == null) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "选择的部门不存在");
        }
        String encryptedPassword = ValidUtils.isValid(sysUserDto.getPassword()) ? DataUtils.md5(sysUserDto.getPassword()) : "";
        SysUser sysUser = SysUser.builder().username(sysUserDto.getUsername()).telephone(sysUserDto.getTelephone()).mail(sysUserDto.getMail())
                .password(encryptedPassword).deptId(sysUserDto.getDeptId()).status(sysUserDto.getStatus()).remark(sysUserDto.getRemark())
                .operator(sysUserDto.getOperator()).operateIp(sysUserDto.getOperateIp()).operateTime(new Date()).build();
        sysUserMapper.insertSelective(sysUser);

        sysLogService.saveUserLog(null, sysUser);
    }

    @Transactional
    @Override
    public void update(SysUserDto sysUserDto) {
        SysUser before = sysUserMapper.selectByPrimaryKey(sysUserDto.getId());
        if (before == null) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "待更新的用户不存在");
        }
        SysUser after = SysUser.builder().id(before.getId()).username(sysUserDto.getUsername()).telephone(sysUserDto.getTelephone()).mail(sysUserDto.getMail())
                .deptId(sysUserDto.getDeptId()).status(sysUserDto.getStatus()).remark(sysUserDto.getRemark())
                .operator(sysUserDto.getOperator()).operateIp(sysUserDto.getOperateIp()).operateTime(new Date()).build();

        if (ValidUtils.isValid(sysUserDto.getPassword())) {
            after.setPassword(DataUtils.md5(sysUserDto.getPassword()));
        }
        sysUserMapper.updateByPrimaryKeySelective(after);

        sysLogService.saveUserLog(before, after);
    }

    @Override
    public PageResultDto<SysUserDto> query(UserQueryDto pageQueryDto) {
        Map<String, Object> condition = BeanMapUtils.beanToMap(pageQueryDto);
        condition.put("excludeStatus", SysUserStatus.DELETED.getValue());
        Page<Object> page = PageHelper.startPage(pageQueryDto.getPageNum(), pageQueryDto.getPageSize()).doSelectPage(() -> sysUserMapper.query(condition));
        return PageUtils.convert(page, SysUserDto.class);
    }

    @Override
    public SysUser findByTelephoneOrMail(String keyword) {
        return sysUserMapper.findByKeyword(keyword);
    }

    @Override
    public List<SysUser> getAll() {
        return sysUserMapper.selectAll();
    }

    @Override
    public SysUser getById(Integer userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public SysUserDto getById(UserIdDto userIdDto) {
        return MapperUtils.map(getById(userIdDto.getUserId()), SysUserDto.class);
    }

    private boolean checkTelephoneExist(String telephone, Integer userId) {
        return sysUserMapper.countByTelephone(telephone, userId) > 0;
    }

    private boolean checkEmailExist(String telephone, Integer userId) {
        return sysUserMapper.countByMail(telephone, userId) > 0;
    }
}
