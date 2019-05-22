package io.github.pactstart.admin.system.controller;

import io.github.pactstart.admin.system.form.SmsRecordQueryForm;
import io.github.pactstart.admin.system.form.SmsTemplateAddForm;
import io.github.pactstart.admin.system.form.SmsTemplateIdForm;
import io.github.pactstart.biz.common.dto.DateBetweenDto;
import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.simple.web.framework.auth.AuthenticationInfo;
import io.github.pactstart.simple.web.framework.common.form.DateBetweenForm;
import io.github.pactstart.simple.web.framework.utils.ParamValidator;
import io.github.pactstart.system.dto.*;
import io.github.pactstart.system.service.SmsDayCountService;
import io.github.pactstart.system.service.SmsRecordService;
import io.github.pactstart.system.service.SmsTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "短信")
@RequestMapping("/sms")
@RestController
public class SmsController {

    @Autowired
    private SmsRecordService smsRecordService;

    @Autowired
    private SmsDayCountService smsDayCountService;

    @Autowired
    private SmsTemplateService smsTemplateService;

    @ApiOperation(value = "添加短信模板")
    @ApiImplicitParam(name = "param", value = "短信模板添加参数", required = true, dataType = "SmsTemplateAddForm")
    @PostMapping("/template/add.json")
    public ResponseCode addSmsTemplate(@Valid @RequestBody SmsTemplateAddForm smsTemplateAddForm, BindingResult br, AuthenticationInfo authenticationInfo) {
        ParamValidator.validate(br);
        SmsTemplateDto smsTemplateDto = MapperUtils.map(smsTemplateAddForm, SmsTemplateDto.class);
        smsTemplateDto.setOperator(authenticationInfo.getUserName());
        smsTemplateService.add(smsTemplateDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "删除短信模板")
    @ApiImplicitParam(name = "param", value = "短信模板id", required = true, dataType = "SmsTemplateIdForm")
    @PostMapping("/template/delete.json")
    public ResponseCode deleteSmsTemplate(@Valid @RequestBody SmsTemplateIdForm smsTemplateIdForm, BindingResult br, AuthenticationInfo authenticationInfo) {
        ParamValidator.validate(br);
        smsTemplateService.deleteByTemplateId(smsTemplateIdForm.getTemplateId());
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "获取所有的短信模板")
    @PostMapping("/template/list.json")
    public ResponseCode getAllSmsTemplate() {
        return ResponseCode.buildResponse(smsTemplateService.getAll());
    }

    @ApiOperation(value = "分页查询短信记录")
    @ApiImplicitParam(name = "param", value = "短信记录查询参数", required = true, dataType = "SmsRecordQueryForm")
    @PostMapping("/sendRecord/page.json")
    public PageResultDto<SmsRecordDto> query(@Valid @RequestBody SmsRecordQueryForm queryForm, BindingResult br) {
        ParamValidator.validate(br);
        SmsRecordQueryDto queryDto = MapperUtils.map(queryForm, SmsRecordQueryDto.class);
        return smsRecordService.query(queryDto);
    }

    @ApiOperation(value = "统计指定日期范围内每天的短信记录")
    @ApiImplicitParam(name = "param", value = "日期范围", required = true, dataType = "DateBetweenForm")
    @PostMapping("/stat.json")
    public ResponseCode statByPeriod(@RequestBody @Valid DateBetweenForm param, BindingResult br) {
        ParamValidator.validate(br);
        LocalDate from = LocalDate.fromDateFields(param.getFromDate());
        LocalDate to = LocalDate.fromDateFields(param.getToDate());
        if (from.isAfter(to)) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "统计开始日期不能大于结束日期");
        }
        LocalDate cur = LocalDate.now();
        if (!from.isBefore(cur)) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "统计开始日期需小于当前日期");
        }
        if (!to.isBefore(cur)) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "统计结束日期需小于当前日期");
        }
        int days = Days.daysBetween(from, to).getDays();
        if (days == 0) {
            //开始日期和结束日期相同时，结束日期加一天
            param.setToDate(from.plusDays(1).toDate());
        } else if (days > 90) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "一次统计的时间不能超过90天");
        }
        DateBetweenDto dateBetweenDto = MapperUtils.map(param, DateBetweenDto.class);
        smsDayCountService.statByDate(dateBetweenDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "根据指定日期范围查询每日短信发送统计")
    @ApiImplicitParam(name = "param", value = "日期范围", required = true, dataType = "DateBetweenForm")
    @PostMapping("/dayCount/list.json")
    public List<SmsDayCountAdaptDto> list(@Valid @RequestBody DateBetweenForm param, BindingResult br) {
        ParamValidator.validate(br);
        SmsDayCountQueryDto queryDto = MapperUtils.map(param, SmsDayCountQueryDto.class);
        return smsDayCountService.query(queryDto);
    }

}
