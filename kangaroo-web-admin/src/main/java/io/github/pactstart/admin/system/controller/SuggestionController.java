package io.github.pactstart.admin.system.controller;

import io.github.pactstart.admin.system.form.SuggestionHandleForm;
import io.github.pactstart.admin.system.form.SuggestionQueryForm;
import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.simple.web.framework.auth.AuthenticationInfo;
import io.github.pactstart.simple.web.framework.utils.ParamValidator;
import io.github.pactstart.system.dto.SuggestionDto;
import io.github.pactstart.system.dto.SuggestionQueryDto;
import io.github.pactstart.system.service.SuggestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "反馈与建议")
@RequestMapping("/suggestion")
@RestController
public class SuggestionController {

    @Autowired
    private SuggestionService suggestionService;

    @ApiOperation("分页查询用户反馈")
    @ApiImplicitParam(name = "queryForm", value = "查询参数", required = true, dataType = "SuggestionQueryForm")
    @PostMapping("/query.json")
    public PageResultDto<SuggestionDto> query(@Valid @RequestBody SuggestionQueryForm queryForm, BindingResult bindingResult) {
        ParamValidator.validate(bindingResult);
        SuggestionQueryDto queryDto = MapperUtils.map(queryForm, SuggestionQueryDto.class);
        return suggestionService.query(queryDto);
    }

    @ApiOperation("处理用户建议或反馈")
    @ApiImplicitParam(name = "handleForm", value = "处理参数", required = true, dataType = "SuggestionHandleForm")
    @PostMapping("/handle.json")
    public ResponseCode handle(@Valid @RequestBody SuggestionHandleForm handleForm, BindingResult bindingResult, AuthenticationInfo authenticationInfo) {
        ParamValidator.validate(bindingResult);
        SuggestionDto suggestionDto = MapperUtils.map(handleForm, SuggestionDto.class);
        suggestionDto.setOperator(authenticationInfo.getUserName());
        suggestionService.handle(suggestionDto);
        return ResponseCode.SUCCESS;
    }
}
