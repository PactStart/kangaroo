package io.github.pactstart.admin.system.controller;

import com.alibaba.fastjson.JSON;
import io.github.pactstart.admin.adpater.KangarooWebAdapter;
import io.github.pactstart.admin.system.form.*;
import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.commonutils.ValidUtils;
import io.github.pactstart.simple.web.framework.auth.AuthenticationInfo;
import io.github.pactstart.simple.web.framework.utils.IpUtils;
import io.github.pactstart.simple.web.framework.utils.ParamValidator;
import io.github.pactstart.system.dto.*;
import io.github.pactstart.system.service.NoticeService;
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

@Api(tags = "通知")
@RequestMapping("/notice")
@RestController
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private KangarooWebAdapter kangarooWebAdapter;

    @ApiOperation(value = "添加平台通知")
    @ApiImplicitParam(name = "platformNoticeAddForm", value = "添加条件", required = true, dataType = "PlatformNoticeAddForm")
    @PostMapping("/platform/add.json")
    public ResponseCode addPlatformNotice(@RequestBody @Valid PlatformNoticeAddForm platformNoticeAddForm, BindingResult br, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(br);
        PlatformNoticeAddDto platformNoticeAddDto = MapperUtils.map(platformNoticeAddForm, PlatformNoticeAddDto.class);
        platformNoticeAddDto.setOperator(authenticationInfo.getUserName());
        platformNoticeAddDto.setOperateIp(IpUtils.getClientIpAddr(request));
        noticeService.addPlatformNotice(platformNoticeAddDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "删除平台通知")
    @ApiImplicitParam(name = "PlatformNoticeIdForm", value = "添加条件", required = true, dataType = "PlatformNoticeIdForm")
    @PostMapping("/platform/delete.json")
    public ResponseCode deletePlatformNotice(@RequestBody @Valid PlatformNoticeIdForm platformNoticeIdForm, BindingResult br, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(br);
        PlatformNoticeIdDto platformNoticeIdDto = new PlatformNoticeIdDto();
        platformNoticeIdDto.setPlatformNoticeId(platformNoticeIdForm.getId());
        noticeService.deletePlatformNotice(platformNoticeIdDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "发送平台通知")
    @ApiImplicitParam(name = "PlatformNoticeIdForm", value = "发送条件", required = true, dataType = "PlatformNoticeIdForm")
    @PostMapping("/platform/send.json")
    public ResponseCode sendPlatformNotice(@RequestBody @Valid PlatformNoticeIdForm platformNoticeIdForm, BindingResult br) {
        ParamValidator.validate(br);
        PlatformNoticeSendDto sendDto = new PlatformNoticeSendDto();
        sendDto.setPlatformNoticeId(platformNoticeIdForm.getId());
        sendDto.setMemberIdList(kangarooWebAdapter.getAllMemberIdList());
        if (!ValidUtils.isValid(sendDto.getMemberIdList())) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "未找到任何目标用户");
        }
        noticeService.sendPlatformNotice(sendDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "查询平台通知")
    @ApiImplicitParam(name = "queryForm", value = "查询条件", required = true, dataType = "PlatformNoticeQueryForm")
    @PostMapping("/platform/query.json")
    public PageResultDto<PlatformNoticeDto> queryPlatformNotice(@RequestBody @Valid PlatformNoticeQueryForm queryForm, BindingResult br) {
        ParamValidator.validate(br);
        PlatformNoticeQueryDto queryDto = MapperUtils.map(queryForm, PlatformNoticeQueryDto.class);
        return noticeService.queryPlatformNotice(queryDto);
    }

    @ApiOperation(value = "查询会员通知")
    @ApiImplicitParam(name = "queryForm", value = "查询条件", required = true, dataType = "MemberNoticeQueryForm")
    @PostMapping("/member/query.json")
    public PageResultDto<MemberNoticeDto> queryMemberNotice(@RequestBody @Valid MemberNoticeQueryForm queryForm, BindingResult br) {
        ParamValidator.validate(br);
        MemberNoticeQueryDto queryDto = MapperUtils.map(queryForm, MemberNoticeQueryDto.class);
        return noticeService.queryMemberNotice(queryDto);
    }

    @ApiOperation(value = "发送自定义会员通知")
    @ApiImplicitParam(name = "customMemberNoticeSendForm", value = "发送条件", required = true, dataType = "CustomMemberNoticeSendForm")
    @PostMapping("/member/sendCustom.json")
    public ResponseCode sendCustomMemberNotice(@RequestBody @Valid CustomMemberNoticeSendForm customMemberNoticeSendForm, BindingResult br) {
        ParamValidator.validate(br);
        if (ValidUtils.isValid(customMemberNoticeSendForm.getContent())) {
            try {
                JSON.parseObject(customMemberNoticeSendForm.getContent());
            } catch (Exception e) {
                throw new ApplicationException(ResponseCode.INVALID_PARAM, "推送内容不是一个合法的json格式");
            }
        }
        CustomMemberNoticeSendDto customMemberNoticeSendDto = MapperUtils.map(customMemberNoticeSendForm, CustomMemberNoticeSendDto.class);
        noticeService.sendCustomMemberNotice(customMemberNoticeSendDto);
        return ResponseCode.SUCCESS;
    }
}
