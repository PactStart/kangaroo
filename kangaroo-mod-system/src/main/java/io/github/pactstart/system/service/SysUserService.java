package io.github.pactstart.system.service;


import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.system.dto.SysUserDto;
import io.github.pactstart.system.dto.UserIdDto;
import io.github.pactstart.system.dto.UserQueryDto;
import io.github.pactstart.system.entity.SysUser;

import java.util.List;

public interface SysUserService {

    /**
     * 添加系统用户
     *
     * @param sysUserDto
     */
    void add(SysUserDto sysUserDto);

    /**
     * 修改系统用户
     *
     * @param sysUserDto
     */
    void update(SysUserDto sysUserDto);

    /**
     * 根据条件分页查询系统用户
     *
     * @param pageQueryDto
     * @return
     */
    PageResultDto<SysUserDto> query(UserQueryDto pageQueryDto);

    /**
     * 通过电话或邮箱查询
     *
     * @param keyword
     * @return
     */
    SysUser findByTelephoneOrMail(String keyword);

    /**
     * 获取所有的系统用户
     *
     * @return
     */
    List<SysUser> getAll();

    /**
     * 根据id获取用户
     *
     * @param userId
     * @return
     */
    SysUser getById(Integer userId);

    /**
     * 根据id获取用户
     *
     * @param userIdDto
     * @return
     */
    SysUserDto getById(UserIdDto userIdDto);
}
