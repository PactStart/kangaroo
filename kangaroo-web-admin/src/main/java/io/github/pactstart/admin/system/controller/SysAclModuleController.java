package io.github.pactstart.admin.system.controller;

import io.github.pactstart.admin.system.form.AclModuleForm;
import io.github.pactstart.biz.common.dto.IdDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.simple.web.framework.auth.AuthenticationInfo;
import io.github.pactstart.simple.web.framework.common.form.IdForm;
import io.github.pactstart.simple.web.framework.utils.IpUtils;
import io.github.pactstart.simple.web.framework.utils.ParamValidator;
import io.github.pactstart.system.dto.SysAclModuleDto;
import io.github.pactstart.system.dto.adapt.SysAclModuleAdaptDto;
import io.github.pactstart.system.service.SysAclModuleService;
import io.github.pactstart.system.service.SysTreeService;
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

@Api(tags = "权限模块")
@RequestMapping("/sys/aclModule")
@RestController
public class SysAclModuleController {

    @Autowired
    private SysAclModuleService sysAclModuleService;

    @Autowired
    private SysTreeService sysTreeService;

    @ApiOperation(value = "添加权限模块")
    @ApiImplicitParam(name = "aclModuleForm", value = "权限模块参数", required = true, dataType = "AclModuleForm")
    @PostMapping("/save.json")
    public ResponseCode saveAclModule(@Valid @RequestBody AclModuleForm aclModuleForm, BindingResult br, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(br);
        SysAclModuleDto sysAclModuleDto = MapperUtils.map(aclModuleForm, SysAclModuleDto.class);
        sysAclModuleDto.setOperator(authenticationInfo.getUserName());
        sysAclModuleDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysAclModuleService.add(sysAclModuleDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "修改权限模块")
    @ApiImplicitParam(name = "aclModuleForm", value = "权限模块参数", required = true, dataType = "AclModuleForm")
    @PostMapping("/update.json")
    public ResponseCode updateAclModule(@Valid @RequestBody AclModuleForm aclModuleForm, BindingResult br, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(br);
        SysAclModuleDto sysAclModuleDto = MapperUtils.map(aclModuleForm, SysAclModuleDto.class);
        sysAclModuleDto.setOperator(authenticationInfo.getUserName());
        sysAclModuleDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysAclModuleService.update(sysAclModuleDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "获取权限模块树")
    @PostMapping("/tree.json")
    public ResponseCode tree() {
        List<SysAclModuleAdaptDto> sysAclModuleAdaptDtoList = sysTreeService.aclModuleTree();
        return ResponseCode.buildResponse(sysAclModuleAdaptDtoList);
    }

    @ApiOperation(value = "删除权限模块")
    @ApiImplicitParam(name = "idForm", value = "权限模块id", required = true, dataType = "IdForm")
    @PostMapping("/delete.json")
    public ResponseCode delete(@Valid @RequestBody IdForm idForm, BindingResult br) {
        ParamValidator.validate(br);
        IdDto idDto = MapperUtils.map(idForm, IdDto.class);
        sysAclModuleService.delete(idDto);
        return ResponseCode.SUCCESS;
    }
}
