package io.github.pactstart.admin.system.controller;

import io.github.pactstart.admin.system.form.DeptForm;
import io.github.pactstart.biz.common.dto.IdDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.simple.web.framework.auth.AuthenticationInfo;
import io.github.pactstart.simple.web.framework.common.form.IdForm;
import io.github.pactstart.simple.web.framework.utils.IpUtils;
import io.github.pactstart.simple.web.framework.utils.ParamValidator;
import io.github.pactstart.system.dto.SysDeptDto;
import io.github.pactstart.system.dto.adapt.SysDeptAdaptDto;
import io.github.pactstart.system.service.SysDeptService;
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

@Api(tags = "部门")
@RequestMapping("/sys/dept")
@RestController
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private SysTreeService sysTreeService;

    @ApiOperation(value = "添加部门")
    @ApiImplicitParam(name = "param", value = "部门参数", required = true, dataType = "DeptForm")
    @PostMapping("/save.json")
    public ResponseCode saveDept(@Valid @RequestBody DeptForm deptForm, BindingResult br, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(br);
        SysDeptDto sysDeptDto = MapperUtils.map(deptForm, SysDeptDto.class);
        sysDeptDto.setOperator(authenticationInfo.getUserName());
        sysDeptDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysDeptService.add(sysDeptDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "修改部门")
    @ApiImplicitParam(name = "param", value = "部门参数", required = true, dataType = "DeptForm")
    @PostMapping("/update.json")
    public ResponseCode update(@Valid @RequestBody DeptForm deptForm, BindingResult br, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(br);
        SysDeptDto sysDeptDto = MapperUtils.map(deptForm, SysDeptDto.class);
        sysDeptDto.setOperator(authenticationInfo.getUserName());
        sysDeptDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysDeptService.update(sysDeptDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "删除部门")
    @ApiImplicitParam(name = "param", value = "部门id", required = true, dataType = "IdForm")
    @PostMapping("/delete.json")
    public ResponseCode delete(@Valid @RequestBody IdForm idForm, BindingResult br) {
        ParamValidator.validate(br);
        IdDto idDto = MapperUtils.map(idForm, IdDto.class);
        sysDeptService.delete(idDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "获取部门树形结构")
    @PostMapping("/tree.json")
    public List<SysDeptAdaptDto> tree() {
        return sysTreeService.deptTree();
    }
}
