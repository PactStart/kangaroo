package io.github.pactstart.admin.system.controller;

import com.google.common.collect.Maps;
import io.github.pactstart.admin.system.form.AclForm;
import io.github.pactstart.admin.system.form.AclIdForm;
import io.github.pactstart.admin.system.form.AclQueryForm;
import io.github.pactstart.biz.common.dto.IdDto;
import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.simple.web.framework.auth.AuthenticationInfo;
import io.github.pactstart.simple.web.framework.common.form.IdForm;
import io.github.pactstart.simple.web.framework.utils.IpUtils;
import io.github.pactstart.simple.web.framework.utils.ParamValidator;
import io.github.pactstart.system.dto.AclQueryDto;
import io.github.pactstart.system.dto.SysAclDto;
import io.github.pactstart.system.entity.SysRole;
import io.github.pactstart.system.service.SysAclService;
import io.github.pactstart.system.service.SysRoleService;
import io.github.pactstart.system.service.SysRoleUserService;
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

@Api(tags = "权限点")
@RequestMapping("/sys/acl")
@RestController
public class SysAclController {

    @Autowired
    private SysAclService sysAclService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysRoleUserService sysRoleUserService;

    @ApiOperation(value = "添加权限点")
    @ApiImplicitParam(name = "aclForm", value = "权限点参数", required = true, dataType = "AclForm")
    @PostMapping(value = "/save.json")
    public ResponseCode saveAclModule(@RequestBody @Valid AclForm aclForm, BindingResult bindingResult, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(bindingResult);
        SysAclDto sysAclDto = MapperUtils.map(aclForm, SysAclDto.class);
        sysAclDto.setOperator(authenticationInfo.getUserName());
        sysAclDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysAclService.add(sysAclDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "修改权限点")
    @ApiImplicitParam(name = "aclForm", value = "权限点参数", required = true, dataType = "AclForm")
    @PostMapping(value = "/update.json")
    public ResponseCode updateAclModule(@RequestBody @Valid AclForm aclForm, BindingResult bindingResult, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(bindingResult);
        SysAclDto sysAclDto = MapperUtils.map(aclForm, SysAclDto.class);
        sysAclDto.setOperator(authenticationInfo.getUserName());
        sysAclDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysAclService.update(sysAclDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "分页查询权限点")
    @ApiImplicitParam(name = "aclQueryForm", value = "查询条件", required = true, dataType = "AclQueryForm")
    @PostMapping(value = "/page.json")
    public PageResultDto<SysAclDto> page(@RequestBody @Valid AclQueryForm aclQueryForm, BindingResult bindingResult) {
        ParamValidator.validate(bindingResult);
        AclQueryDto aclQueryDto = MapperUtils.map(aclQueryForm, AclQueryDto.class);
        return sysAclService.query(aclQueryDto);
    }

    @ApiOperation(value = "删除权限点")
    @ApiImplicitParam(name = "idForm", value = "权限点id", required = true, dataType = "IdForm")
    @PostMapping(value = "/delete.json")
    public ResponseCode delete(@RequestBody @Valid IdForm idForm, BindingResult bindingResult) {
        ParamValidator.validate(bindingResult);
        IdDto idDto = MapperUtils.map(idForm, IdDto.class);
        sysAclService.delete(idDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "获取拥有某个权限点的所有角色和用户")
    @ApiImplicitParam(name = "aclIdForm", value = "权限点id", required = true, dataType = "AclIdForm")
    @PostMapping(value = "/acls.json")
    public ResponseCode acls(@Valid AclIdForm aclIdForm, BindingResult br) {
        ParamValidator.validate(br);
        Map<String, Object> data = Maps.newHashMap();
        List<SysRole> roleList = sysRoleService.getRoleListByAclId(aclIdForm.getAclId());
        data.put("roles", roleList);
        data.put("users", sysRoleUserService.getUserListByRoleList(roleList));
        return ResponseCode.buildResponse(data);
    }
}
