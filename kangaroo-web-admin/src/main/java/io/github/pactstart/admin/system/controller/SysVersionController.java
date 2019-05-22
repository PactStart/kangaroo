package io.github.pactstart.admin.system.controller;

import io.github.pactstart.admin.system.form.SysVersionForm;
import io.github.pactstart.admin.system.form.SysVersionQueryForm;
import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.simple.web.framework.auth.AuthenticationInfo;
import io.github.pactstart.simple.web.framework.utils.IpUtils;
import io.github.pactstart.simple.web.framework.utils.ParamValidator;
import io.github.pactstart.system.dto.SysVersionDto;
import io.github.pactstart.system.dto.SysVersionQueryDto;
import io.github.pactstart.system.service.SysVersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(tags = "版本管理")
@RequestMapping(value = "/version", method = RequestMethod.POST, consumes = "application/json")
@RestController
public class SysVersionController {

    @Autowired
    private SysVersionService sysVersionService;

    @ApiOperation(value = "添加版本")
    @ApiImplicitParam(name = "param", value = "", required = true, dataType = "SysVersionForm")
    @PostMapping("/add.json")
    public ResponseCode add(@RequestBody @Valid SysVersionForm param, BindingResult br, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(br);
        SysVersionDto sysVersionDto = MapperUtils.map(param, SysVersionDto.class);
        sysVersionDto.setOperator(authenticationInfo.getUserName());
        sysVersionDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysVersionService.add(sysVersionDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "修改版本")
    @ApiImplicitParam(name = "param", value = "", required = true, dataType = "SysVersionForm")
    @PostMapping("/update.json")
    public ResponseCode update(@RequestBody @Valid SysVersionForm param, BindingResult br, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(br);
        SysVersionDto sysVersionDto = MapperUtils.map(param, SysVersionDto.class);
        sysVersionDto.setOperator(authenticationInfo.getUserName());
        sysVersionDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysVersionService.update(sysVersionDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "分页查询版本记录")
    @ApiImplicitParam(name = "param", value = "查询条件", required = true, dataType = "SysVersionQueryForm")
    @PostMapping("/query.json")
    public PageResultDto<SysVersionDto> query(@RequestBody @Valid SysVersionQueryForm param, BindingResult br) {
        ParamValidator.validate(br);
        SysVersionQueryDto queryDto = MapperUtils.map(param, SysVersionQueryDto.class);
        return sysVersionService.query(queryDto);
    }
}
