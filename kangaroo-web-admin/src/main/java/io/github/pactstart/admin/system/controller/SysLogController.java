package io.github.pactstart.admin.system.controller;

import io.github.pactstart.admin.system.form.SearchLogForm;
import io.github.pactstart.biz.common.dto.IdOperateDto;
import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.simple.web.framework.auth.AuthenticationInfo;
import io.github.pactstart.simple.web.framework.common.form.IdForm;
import io.github.pactstart.simple.web.framework.utils.IpUtils;
import io.github.pactstart.simple.web.framework.utils.ParamValidator;
import io.github.pactstart.system.dto.LogQueryDto;
import io.github.pactstart.system.dto.SysLogDto;
import io.github.pactstart.system.service.SysLogService;
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

@Api(tags = "系统日志")
@RequestMapping("/sys/log")
@RestController
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @ApiOperation(value = "还原某个操作")
    @ApiImplicitParam(name = "param", value = "日志id", required = true, dataType = "IdForm")
    @PostMapping("/recover.json")
    public ResponseCode recover(@RequestBody @Valid IdForm idForm, BindingResult br, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(br);
        IdOperateDto idOperateDto = MapperUtils.map(idForm, IdOperateDto.class);
        idOperateDto.setOperator(authenticationInfo.getUserName());
        idOperateDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysLogService.recover(idOperateDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "分页查询系统日志")
    @ApiImplicitParam(name = "param", value = "查询条件", required = true, dataType = "SearchLogForm")
    @PostMapping("/page.json")
    public PageResultDto<SysLogDto> searchPage(@Valid @RequestBody SearchLogForm searchLogForm, BindingResult br) {
        ParamValidator.validate(br);
        LogQueryDto logQueryDto = MapperUtils.map(searchLogForm, LogQueryDto.class);
        return sysLogService.query(logQueryDto);
    }
}
