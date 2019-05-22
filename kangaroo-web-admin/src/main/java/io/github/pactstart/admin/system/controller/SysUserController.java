package io.github.pactstart.admin.system.controller;

import com.google.common.collect.Maps;
import io.github.pactstart.admin.adpater.KangarooWebAdapter;
import io.github.pactstart.admin.adpater.vo.SmsTemplateAndParams;
import io.github.pactstart.admin.auth.AdminAuthorizationInfo;
import io.github.pactstart.admin.auth.AdminConstants;
import io.github.pactstart.admin.system.form.*;
import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.commonutils.DataUtils;
import io.github.pactstart.simple.web.framework.auth.AuthenticationInfo;
import io.github.pactstart.simple.web.framework.auth.SimpleUserInfo;
import io.github.pactstart.simple.web.framework.utils.IpUtils;
import io.github.pactstart.simple.web.framework.utils.ParamValidator;
import io.github.pactstart.system.dto.SysAclDto;
import io.github.pactstart.system.dto.SysUserDto;
import io.github.pactstart.system.dto.UserIdDto;
import io.github.pactstart.system.dto.UserQueryDto;
import io.github.pactstart.system.entity.SysUser;
import io.github.pactstart.system.enums.SysUserStatus;
import io.github.pactstart.system.errorcode.SysResponseCode;
import io.github.pactstart.system.facade.SmsServiceFacade;
import io.github.pactstart.system.facade.dto.*;
import io.github.pactstart.system.service.SysCoreService;
import io.github.pactstart.system.service.SysRoleService;
import io.github.pactstart.system.service.SysTreeService;
import io.github.pactstart.system.service.SysUserService;
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
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Api(tags = "系统用户")
@RequestMapping("/sys/user")
@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysCoreService sysCoreService;

    @Autowired
    private SysTreeService sysTreeService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SmsServiceFacade smsServiceFacade;

    @Autowired
    private KangarooWebAdapter kangarooWebAdapter;

    @ApiOperation(value = "发送短信")
    @ApiImplicitParam(name = "smsSendForm", value = "手机号+短信场景", required = true, dataType = "SmsSendForm")
    @PostMapping(value = "/sendSms.json")
    public ResponseCode sendSms(HttpServletRequest request, @RequestBody @Valid SmsSendForm smsSendForm, BindingResult bindingResult, AuthenticationInfo authenticationInfo) {
        ParamValidator.validate(bindingResult);
        SmsTemplateAndParams smsTemplateAndParams = kangarooWebAdapter.getSmsParam(smsSendForm, authenticationInfo);
        SmsSendParamDto smsSendParamDto = SmsSendParamDto.builder().phone(smsSendForm.getPhone()).templateId(smsTemplateAndParams.getTemplateId())
                .signName(smsTemplateAndParams.getSignName()).codeLength(smsTemplateAndParams.getCodeLength()).params(smsTemplateAndParams.getTemplateParams()).build();
        SmsSendResultDto smsSendResultDto = smsServiceFacade.sendValidateSms(smsSendParamDto);
        if (!smsSendResultDto.isSuccess()) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, smsSendResultDto.getFailReason());
        }
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "用户名或邮箱密码登录")
    @ApiImplicitParam(name = "userPasswordLoginForm", value = "用户参数", required = true, dataType = "UserPasswordLoginForm")
    @PostMapping(value = "/login.json")
    public ResponseCode loginByPassword(@RequestBody @Valid UserPasswordLoginForm userPasswordLoginForm, BindingResult bindingResult, HttpSession session) {
        ParamValidator.validate(bindingResult);
        SysUser sysUser = sysUserService.findByTelephoneOrMail(userPasswordLoginForm.getLoginId());
        if (sysUser == null || SysUserStatus.valueOf(sysUser.getStatus()) == SysUserStatus.DELETED) {
            return SysResponseCode.SYS_USER_NOT_EXIST;
        } else if (!DataUtils.md5(userPasswordLoginForm.getPassword()).equals(sysUser.getPassword())) {
            return SysResponseCode.SYS_USER_PASSWORD_ERROR;
        } else if (SysUserStatus.valueOf(sysUser.getStatus()) == SysUserStatus.FROZEN) {
            return SysResponseCode.SYS_USER_FROZEN;
        }
        Map<String, Object> data = login(sysUser, session);
        return ResponseCode.buildResponse(data);
    }

    private Map<String, Object> login(SysUser sysUser, HttpSession session) {
        AdminAuthorizationInfo authorizationInfo = new AdminAuthorizationInfo();
        SimpleUserInfo userInfo = new SimpleUserInfo();
        userInfo.setId(sysUser.getId());
        userInfo.setUsername(sysUser.getUsername());
        authorizationInfo.setUserInfo(userInfo);
        session.setAttribute(AdminConstants.SYS_USER_SESSION_KEY, authorizationInfo);
        Map<String, Object> data = Maps.newHashMap();
        data.put("user", MapperUtils.map(sysUser, SysUserDto.class));
        data.put("acls", sysTreeService.userAclTree(sysUser.getId()));
        data.put("roles", sysRoleService.getRoleListByUserId(sysUser.getId()));
        return data;
    }

    @ApiOperation(value = "手机验证码登录")
    @ApiImplicitParam(name = "userPhoneSmsLoginForm", value = "手机号与验证码", required = true, dataType = "UserPhoneSmsLoginForm")
    @PostMapping(value = "/loginByPhoneSms.json")
    public ResponseCode modifyPassword(@RequestBody @Valid UserPhoneSmsLoginForm userPhoneSmsLoginForm, BindingResult bindingResult, HttpSession session) {
        ParamValidator.validate(bindingResult);
        SmsCodeValidateParamDto smsCodeValidateParamDto = SmsCodeValidateParamDto.builder().phone(userPhoneSmsLoginForm.getPhone()).code(userPhoneSmsLoginForm.getSmsCode())
                .templateId(kangarooWebAdapter.getPhoneLoginSmsTemplate()).removeAfterPass(false).build();
        SmsCodeValidateResultDto smsCodeValidateResultDto = smsServiceFacade.validateSmsCode(smsCodeValidateParamDto);
        if (!smsCodeValidateResultDto.isSuccess()) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, smsCodeValidateResultDto.getFailReason());
        }
        SysUser sysUser = sysUserService.findByTelephoneOrMail(userPhoneSmsLoginForm.getPhone());
        if (sysUser == null || SysUserStatus.valueOf(sysUser.getStatus()) == SysUserStatus.DELETED) {
            return SysResponseCode.SYS_USER_NOT_EXIST;
        } else if (SysUserStatus.valueOf(sysUser.getStatus()) == SysUserStatus.FROZEN) {
            return SysResponseCode.SYS_USER_FROZEN;
        }
        Map<String, Object> data = login(sysUser, session);

        SmsCodeRemoveDto removeDto = SmsCodeRemoveDto.builder().phone(userPhoneSmsLoginForm.getPhone()).templateId(kangarooWebAdapter.getPhoneLoginSmsTemplate()).build();
        smsServiceFacade.removeSmsCode(removeDto);

        return ResponseCode.buildResponse(data);
    }

    @ApiOperation(value = "修改密码")
    @ApiImplicitParam(name = "userPasswordModifyForm", value = "旧密码与新密码", required = true, dataType = "UserPasswordModifyForm")
    @PostMapping(value = "/modifyPassword.json")
    public ResponseCode modifyPassword(@RequestBody @Valid UserPasswordModifyForm userPasswordModifyForm, BindingResult bindingResult, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(bindingResult);
        Integer userId = authenticationInfo.getUserId();
        SysUser sysUser = sysUserService.getById(userId);
        if (sysUser == null || SysUserStatus.valueOf(sysUser.getStatus()) == SysUserStatus.DELETED) {
            return SysResponseCode.SYS_USER_NOT_EXIST;
        }
        if (!DataUtils.md5(userPasswordModifyForm.getPassword()).equals(sysUser.getPassword())) {
            return new ResponseCode(SysResponseCode.SYS_USER_PASSWORD_ERROR, "当前密码错误");
        }
        if (!userPasswordModifyForm.getConfirmNewPassword().equals(userPasswordModifyForm.getNewPassword())) {
            return new ResponseCode(ResponseCode.INVALID_PARAM, "确认密码与新密码不一致");
        }
        SysUserDto sysUserDto = new SysUserDto();
        sysUserDto.setId(userId);
        sysUserDto.setPassword(userPasswordModifyForm.getNewPassword());
        sysUserDto.setOperator(authenticationInfo.getUserName());
        sysUserDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysUserService.update(sysUserDto);

        return ResponseCode.buildResponse(null);
    }

    @ApiOperation(value = "找回密码")
    @ApiImplicitParam(name = "userPasswordGetBackForm", value = "手机号找回：手机号+短信验证码", required = true, dataType = "UserPasswordGetBackForm")
    @PostMapping(value = "/getBackPassword.json")
    public ResponseCode getBackPassword(@RequestBody @Valid UserPasswordGetBackForm userPasswordGetBackForm, BindingResult bindingResult, HttpServletRequest request) {
        ParamValidator.validate(bindingResult);

        SmsCodeValidateParamDto smsCodeValidateParamDto = SmsCodeValidateParamDto.builder().phone(userPasswordGetBackForm.getPhone()).code(userPasswordGetBackForm.getSmsCode())
                .templateId(kangarooWebAdapter.getPasswordGetBackSmsTemplate()).removeAfterPass(false).build();
        SmsCodeValidateResultDto smsCodeValidateResultDto = smsServiceFacade.validateSmsCode(smsCodeValidateParamDto);
        if (!smsCodeValidateResultDto.isSuccess()) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, smsCodeValidateResultDto.getFailReason());
        }
        SysUser sysUser = sysUserService.findByTelephoneOrMail(userPasswordGetBackForm.getPhone());
        if (sysUser == null || SysUserStatus.valueOf(sysUser.getStatus()) == SysUserStatus.DELETED) {
            return SysResponseCode.SYS_USER_NOT_EXIST;
        }

        SysUserDto sysUserDto = new SysUserDto();
        sysUserDto.setId(sysUser.getId());
        sysUserDto.setPassword(userPasswordGetBackForm.getPassword());
        sysUserDto.setOperator(userPasswordGetBackForm.getPhone());
        sysUserDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysUserService.update(sysUserDto);

        SmsCodeRemoveDto removeDto = SmsCodeRemoveDto.builder().phone(userPasswordGetBackForm.getPhone()).templateId(kangarooWebAdapter.getPasswordGetBackSmsTemplate()).build();
        smsServiceFacade.removeSmsCode(removeDto);

        return ResponseCode.buildResponse(null);
    }

    @ApiOperation(value = "修改手机")
    @ApiImplicitParam(name = "userTelPhoneModifyForm", value = "手机号+短信验证码+当前密码", required = true, dataType = "UserTelPhoneModifyForm")
    @PostMapping(value = "/modifyTelephone.json")
    public ResponseCode getBackPassword(@RequestBody @Valid UserTelPhoneModifyForm userTelPhoneModifyForm, BindingResult bindingResult, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(bindingResult);

        SmsCodeValidateParamDto smsCodeValidateParamDto = SmsCodeValidateParamDto.builder().phone(userTelPhoneModifyForm.getTelephone()).code(userTelPhoneModifyForm.getSmsCode())
                .templateId(kangarooWebAdapter.getPhoneModifySmsTemplate()).removeAfterPass(false).build();
        SmsCodeValidateResultDto smsCodeValidateResultDto = smsServiceFacade.validateSmsCode(smsCodeValidateParamDto);
        if (!smsCodeValidateResultDto.isSuccess()) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, smsCodeValidateResultDto.getFailReason());
        }

        SysUserDto sysUserDto = new SysUserDto();
        sysUserDto.setId(authenticationInfo.getUserId());
        sysUserDto.setTelephone(userTelPhoneModifyForm.getTelephone());
        sysUserDto.setOperator(authenticationInfo.getUserName());
        sysUserDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysUserService.update(sysUserDto);

        SmsCodeRemoveDto removeDto = SmsCodeRemoveDto.builder().phone(userTelPhoneModifyForm.getTelephone()).templateId(kangarooWebAdapter.getPhoneModifySmsTemplate()).build();
        smsServiceFacade.removeSmsCode(removeDto);

        return ResponseCode.buildResponse(null);
    }

    @ApiOperation(value = "修改自己的个人信息")
    @ApiImplicitParam(name = "userInfoModifyForm", value = "个人信息", required = true, dataType = "UserInfoModifyForm")
    @PostMapping(value = "/modifyUsrInfo.json")
    public ResponseCode getBackPassword(@RequestBody @Valid UserInfoModifyForm userInfoModifyForm, BindingResult bindingResult, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(bindingResult);

        SysUserDto sysUserDto = MapperUtils.map(userInfoModifyForm, SysUserDto.class);
        sysUserDto.setId(authenticationInfo.getUserId());
        sysUserDto.setOperator(authenticationInfo.getUserName());
        sysUserDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysUserService.update(sysUserDto);

        return ResponseCode.buildResponse(null);
    }

    @ApiOperation(value = "登出")
    @PostMapping(value = "/logout.json")
    public ResponseCode logout(HttpSession session) {
        session.invalidate();
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "添加系统用户")
    @ApiImplicitParam(name = "userAddForm", value = "用户参数", required = true, dataType = "UserAddForm")
    @PostMapping(value = "/save.json")
    public ResponseCode saveUser(@RequestBody @Valid UserAddForm userAddForm, BindingResult bindingResult, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(bindingResult);
        SysUserDto sysUserDto = MapperUtils.map(userAddForm, SysUserDto.class);
        sysUserDto.setOperator(authenticationInfo.getUserName());
        sysUserDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysUserService.add(sysUserDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "修改系统用户")
    @ApiImplicitParam(name = "userUpdateForm", value = "用户参数", required = true, dataType = "UserUpdateForm")
    @PostMapping(value = "/update.json")
    public ResponseCode updateUser(@RequestBody @Valid UserUpdateForm userUpdateForm, BindingResult bindingResult, AuthenticationInfo authenticationInfo, HttpServletRequest request) {
        ParamValidator.validate(bindingResult);
        SysUserDto sysUserDto = MapperUtils.map(userUpdateForm, SysUserDto.class);
        sysUserDto.setOperator(authenticationInfo.getUserName());
        sysUserDto.setOperateIp(IpUtils.getClientIpAddr(request));
        sysUserService.update(sysUserDto);
        return ResponseCode.SUCCESS;
    }

    @ApiOperation(value = "分页查询系统用户")
    @ApiImplicitParam(name = "userQueryForm", value = "查询条件", required = true, dataType = "UserQueryForm")
    @PostMapping(value = "/page.json")
    public PageResultDto<SysUserDto> page(@Valid @RequestBody UserQueryForm userQueryForm, BindingResult bindingResult) {
        ParamValidator.validate(bindingResult);
        UserQueryDto userQueryDto = MapperUtils.map(userQueryForm, UserQueryDto.class);
        return sysUserService.query(userQueryDto);
    }

    @ApiOperation(value = "获取当前用户信息和拥有的权限")
    @PostMapping(value = "/getUserInfo.json")
    public ResponseCode getUserInfo(AuthenticationInfo authenticationInfo) {
        UserIdDto userIdDto = new UserIdDto();
        userIdDto.setUserId(authenticationInfo.getUserId());
        List<SysAclDto> sysAclList = sysCoreService.getUserAclList(userIdDto);
        SysUserDto sysUser = sysUserService.getById(userIdDto);
        Map<String, Object> data = Maps.newHashMap();
        data.put("superAdmin", kangarooWebAdapter.isSuperAdmin(authenticationInfo));
        data.put("acls", sysAclList);
        data.put("userInfo", sysUser);
        return ResponseCode.buildResponse(data);
    }

    @ApiOperation(value = "获某个用户具备的角色和权限（树形结构)")
    @ApiImplicitParam(name = "userIdForm", value = "用户id", required = true, dataType = "UserIdForm")
    @PostMapping(value = "/acl.json")
    public ResponseCode acls(@Valid @RequestBody UserIdForm userIdForm, BindingResult bindingResult) {
        ParamValidator.validate(bindingResult);
        Map<String, Object> data = Maps.newHashMap();
        data.put("acls", sysTreeService.userAclTree(userIdForm.getUserId()));
        data.put("roles", sysRoleService.getRoleListByUserId(userIdForm.getUserId()));
        return ResponseCode.buildResponse(data);
    }
}
