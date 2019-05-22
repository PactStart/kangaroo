package io.github.pactstart.admin.system.controller;

import com.google.common.collect.Maps;
import io.github.pactstart.admin.system.form.RoleAclChangeForm;
import io.github.pactstart.admin.system.form.RoleForm;
import io.github.pactstart.admin.system.form.RoleIdForm;
import io.github.pactstart.admin.system.form.RoleUserChangeForm;
import io.github.pactstart.biz.common.dto.IdDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.simple.web.framework.auth.AuthenticationInfo;
import io.github.pactstart.simple.web.framework.common.RequestHolder;
import io.github.pactstart.simple.web.framework.common.form.IdForm;
import io.github.pactstart.simple.web.framework.utils.IpUtils;
import io.github.pactstart.simple.web.framework.utils.ParamValidator;
import io.github.pactstart.system.dto.RoleAclListDto;
import io.github.pactstart.system.dto.RoleUserListDto;
import io.github.pactstart.system.dto.SysRoleDto;
import io.github.pactstart.system.dto.adapt.SysAclModuleAdaptDto;
import io.github.pactstart.system.entity.SysRole;
import io.github.pactstart.system.entity.SysUser;
import io.github.pactstart.system.enums.SysUserStatus;
import io.github.pactstart.system.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Api(tags = "角色")
@RequestMapping("/sys/role")
@RestController
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleAclService sysRoleAclService;

    @Autowired
    private SysRoleUserService sysRoleUserService;

    @Autowired
    private SysTreeService sysTreeService;

    @ApiOperation(value = "添加角色")
    @ApiImplicitParam(name = "param", value = "角色参数", required = true, dataType = "RoleForm")
    @PostMapping("/save.json")
    public ResponseCode saveRole(@Valid @RequestBody RoleForm roleForm, BindingResult br, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(br);
        SysRoleDto sysRoleDto = MapperUtils.map(roleForm, SysRoleDto.class);
        sysRoleDto.setOperator(authenticationInfo.getUserName());
        sysRoleDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysRoleService.add(sysRoleDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "修改角色")
    @ApiImplicitParam(name = "param", value = "角色参数", required = true, dataType = "RoleForm")
    @PostMapping("/update.json")
    public ResponseCode updateRole(@Valid @RequestBody RoleForm roleForm, BindingResult br, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(br);
        SysRoleDto sysRoleDto = MapperUtils.map(roleForm, SysRoleDto.class);
        sysRoleDto.setOperator(authenticationInfo.getUserName());
        sysRoleDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysRoleService.update(sysRoleDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "删除角色")
    @ApiImplicitParam(name = "param", value = "角色id", required = true, dataType = "RoleIdParam")
    @PostMapping("/delete.json")
    public ResponseCode deleteRole(@Valid @RequestBody IdForm param, BindingResult br) {
        ParamValidator.validate(br);
        IdDto idDto = MapperUtils.map(param, IdDto.class);
        sysRoleService.delete(idDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "获取所有角色")
    @PostMapping("/list.json")
    public List<SysRole> list() {
        return sysRoleService.getAll();
    }

    @ApiOperation(value = "获取当前用户的角色权限树")
    @ApiImplicitParam(name = "param", value = "角色id", required = true, dataType = "RoleIdParam")
    @PostMapping("/roleTree.json")
    public List<SysAclModuleAdaptDto> roleTree(@Valid @RequestBody RoleIdForm roleIdForm, BindingResult br) {
        ParamValidator.validate(br);
        return sysTreeService.roleTree(roleIdForm.getRoleId(), RequestHolder.getAuthenticationInfo().getUserId());
    }

    @ApiOperation(value = "获取指定角色的权限树")
    @ApiImplicitParam(name = "param", value = "角色id", required = true, dataType = "RoleIdParam")
    @PostMapping("/acls.json")
    public List<SysAclModuleAdaptDto> getRoleAcls(@Valid @RequestBody RoleIdForm roleIdForm, BindingResult br) {
        ParamValidator.validate(br);
        return sysTreeService.roleAclTree(roleIdForm.getRoleId());
    }

    @ApiOperation(value = "分配权限给角色")
    @ApiImplicitParam(name = "changeForm", value = "角色id和权限点id数组", required = true, dataType = "RoleAclChangeForm")
    @PostMapping("/changeAcls.json")
    public ResponseCode changeAcls(@Valid @RequestBody RoleAclChangeForm changeForm, BindingResult br, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(br);
        RoleAclListDto roleAclListDto = MapperUtils.map(changeForm, RoleAclListDto.class);
        roleAclListDto.setOperator(authenticationInfo.getUserName());
        roleAclListDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysRoleAclService.changeRoleAcls(roleAclListDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "分配角色给用户")
    @ApiImplicitParam(name = "changeForm", value = "角色id和用户id数组", required = true, dataType = "RoleUserChangeForm")
    @PostMapping("/changeUsers.json")
    public ResponseCode changeUsers(@Valid @RequestBody RoleUserChangeForm changeForm, BindingResult br, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(br);
        RoleUserListDto roleUserListDto = MapperUtils.map(changeForm, RoleUserListDto.class);
        roleUserListDto.setOperator(authenticationInfo.getUserName());
        roleUserListDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysRoleUserService.changeRoleUsers(roleUserListDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "获取拥有此角色和不拥有此角色的所有用户")
    @ApiImplicitParam(name = "param", value = "角色id", required = true, dataType = "RoleIdForm")
    @PostMapping("/users.json")
    public ResponseCode users(@Valid @RequestBody RoleIdForm roleIdForm, BindingResult br) {
        ParamValidator.validate(br);
        List<SysUser> selectedUserList = sysRoleUserService.getListByRoleId(roleIdForm.getRoleId());
        List<SysUser> allUserList = sysUserService.getAll();

        Set<Integer> selectedUserIdSet = selectedUserList.stream().map(sysUser -> sysUser.getId()).collect(Collectors.toSet());
        List<SysUser> unselectedUserList = allUserList.stream().filter(sysUser -> SysUserStatus.valueOf(sysUser.getStatus()) == SysUserStatus.NORMAL
                && !selectedUserIdSet.contains(sysUser.getId())).collect(Collectors.toList());

        Map<String, List<SysUser>> data = Maps.newHashMap();
        data.put("selected", selectedUserList);
        data.put("unselected", unselectedUserList);
        return ResponseCode.buildResponse(data);
    }
}
