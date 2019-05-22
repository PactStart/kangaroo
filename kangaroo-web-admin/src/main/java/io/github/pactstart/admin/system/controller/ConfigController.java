package io.github.pactstart.admin.system.controller;

import com.google.common.collect.Maps;
import io.github.pactstart.admin.adpater.KangarooWebAdapter;
import io.github.pactstart.admin.system.form.*;
import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.biz.common.vo.NameValuePair;
import io.github.pactstart.simple.web.framework.auth.AuthenticationInfo;
import io.github.pactstart.simple.web.framework.utils.IpUtils;
import io.github.pactstart.simple.web.framework.utils.ParamValidator;
import io.github.pactstart.system.component.ConfigComponent;
import io.github.pactstart.system.dto.*;
import io.github.pactstart.system.enums.ConfigValueTypeEnum;
import io.github.pactstart.system.service.ConfigService;
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
import java.util.HashMap;
import java.util.List;

@Api(tags = "系统配置")
@RequestMapping("/config")
@RestController
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @Autowired
    private KangarooWebAdapter kangarooWebAdapter;

    @Autowired
    private ConfigComponent configComponent;

    @ApiOperation(value = "获取所有的命名空间和配置类型")
    @PostMapping("/selectAllNamespaceAndType.json")
    public ResponseCode selectAllNamespace() {
        List<NameValuePair> namespaceList = kangarooWebAdapter.getAllNamespace();
        List<NameValuePair> configValueTypeList = ConfigValueTypeEnum.selectAll();
        HashMap<String, List<NameValuePair>> data = Maps.newHashMap();
        data.put("namespaceList", namespaceList);
        data.put("configValueTypeList", configValueTypeList);
        return ResponseCode.buildResponse(data);
    }

    @ApiOperation(value = "刷新配置")
    @PostMapping("/refresh.json")
    public ResponseCode refresh() {
        configComponent.reload();
        kangarooWebAdapter.afterConfigReload();
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "分页查询配置")
    @ApiImplicitParam(name = "param", value = "查询条件", required = true, dataType = "ConfigQueryForm")
    @PostMapping("/query.json")
    public PageResultDto<ConfigDto> query(@RequestBody @Valid ConfigQueryForm param, BindingResult br) {
        ParamValidator.validate(br);
        ConfigQueryDto queryDto = MapperUtils.map(param, ConfigQueryDto.class);
        return configService.query(queryDto);
    }

    @ApiOperation(value = "添加配置")
    @ApiImplicitParam(name = "param", value = "添加参数", required = true, dataType = "ConfigAddForm")
    @PostMapping("/add.json")
    public ResponseCode add(@RequestBody @Valid ConfigAddForm param, BindingResult br, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(br);
        kangarooWebAdapter.validateNamespace(param.getNamespace());
        ConfigDto configDto = MapperUtils.map(param, ConfigDto.class);
        configDto.setOperator(authenticationInfo.getUserName());
        configDto.setOperateIp(IpUtils.getClientIpAddr(request));
        configService.add(configDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "更新配置")
    @ApiImplicitParam(name = "param", value = "更新参数", required = true, dataType = "ConfigUpdateForm")
    @PostMapping("/update.json")
    public ResponseCode update(@RequestBody @Valid ConfigUpdateForm param, BindingResult br, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(br);
        ConfigUpdateDto configUpdateDto = MapperUtils.map(param, ConfigUpdateDto.class);
        configUpdateDto.setOperator(authenticationInfo.getUserName());
        configUpdateDto.setOperateIp(IpUtils.getClientIpAddr(request));
        configService.update(configUpdateDto);
        ConfigDto configDto = configService.getById(param.getId());
        configComponent.updateConfig(configDto.getNamespace(), configDto.getName(), configDto.getValue());
        kangarooWebAdapter.afterUpdateConfig(configDto);

        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "删除配置")
    @ApiImplicitParam(name = "param", value = "命名空间与名称", required = true, dataType = "ConfigDeleteForm")
    @PostMapping("/delete.json")
    public ResponseCode delete(@RequestBody @Valid ConfigDeleteForm param, BindingResult br, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(br);
        ConfigDeleteDto configDeleteDto = MapperUtils.map(param, ConfigDeleteDto.class);
        configDeleteDto.setOperator(authenticationInfo.getUserName());
        configDeleteDto.setOperateIp(IpUtils.getClientIpAddr(request));
        configService.delete(configDeleteDto);
        configComponent.removeConfig(param.getNamespace(), param.getName());
        kangarooWebAdapter.afterRemoveConfig(param.getNamespace(), param.getName());

        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "分页查询配置日志")
    @ApiImplicitParam(name = "param", value = "查询条件", required = true, dataType = "ConfigLogQueryForm")
    @PostMapping("/queryLog.json")
    public PageResultDto<ConfigLogDto> query(@RequestBody @Valid ConfigLogQueryForm param, BindingResult br) {
        ParamValidator.validate(br);
        ConfigLogQueryDto queryDto = MapperUtils.map(param, ConfigLogQueryDto.class);
        return configService.queryLog(queryDto);
    }
}
