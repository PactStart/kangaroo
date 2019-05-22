package io.github.pactstart.admin.adpater;

import com.google.common.collect.Lists;
import io.github.pactstart.admin.adpater.vo.SmsTemplateAndParams;
import io.github.pactstart.admin.system.form.SmsSendForm;
import io.github.pactstart.admin.system.form.UploadSceneForm;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import io.github.pactstart.biz.common.vo.NameValuePair;
import io.github.pactstart.simple.web.framework.auth.AuthenticationInfo;
import io.github.pactstart.system.dto.ConfigDto;
import io.github.pactstart.system.dto.UploadPathDto;

import java.util.List;

public class KangarooWebAdapter {

    /**
     * 更新配置后置操作，例如发送mq消息通知订阅者更新缓存的配置
     *
     * @param configDto
     */
    public void afterUpdateConfig(ConfigDto configDto) {

    }

    /**
     * 移除配置后置操作
     *
     * @param namespace
     * @param name
     */
    public void afterRemoveConfig(String namespace, String name) {

    }

    /**
     * 重新加载配置后置操作，例如发送mq消息通知订阅者更新缓存的配置
     */
    public void afterConfigReload() {

    }

    /**
     * 这里控制上传场景与OSS路径的映射关系
     * @param authenticationInfo
     * @param uploadSceneForm
     * @return
     */
    public UploadPathDto beforeGetOssSecurityTokenOrPolicy(AuthenticationInfo authenticationInfo, UploadSceneForm uploadSceneForm) {
        UploadPathDto uploadPathDto = new UploadPathDto();
        uploadPathDto.setPath(uploadSceneForm.getScene());
        return uploadPathDto;
    }

    /**
     * 获取所有的会员id列表
     *
     * @return
     */
    public List<Integer> getAllMemberIdList() {
        return Lists.newArrayList();
    }

    /**
     * 获取所有的配置名称空间
     * @return
     */
    public List<NameValuePair> getAllNamespace() {
        List<NameValuePair> list = Lists.newArrayList();
        NameValuePair pair = new NameValuePair();
        pair.setName("系统");
        pair.setValue("system");
        list.add(pair);
        return list;
    }

    /**
     * 验证配置名称空间，验证不通过，请抛出异常
     * @param namespace
     */
    public void validateNamespace(String namespace) {

    }

    public String getPhoneLoginSmsTemplate() {
//        return "SYS_USER_LOGIN_BY_PHONE_SMS";
        throw new ApplicationException(ResponseCode.SYSTEM_ERROR, "未配置手机验证码登录的短信模板");
    }

    public String getPasswordGetBackSmsTemplate() {
//        return "SYS_USER_PASSWORD_GET_BACK";
        throw new ApplicationException(ResponseCode.SYSTEM_ERROR, "未配置手机找回密码的短信模板");
    }


    public String getPhoneModifySmsTemplate() {
//        return "SYS_USER_PHONE_MODIFY";
        throw new ApplicationException(ResponseCode.SYSTEM_ERROR, "未配置修改手机号的短信模板");
    }

    /**
     * 这里控制短信场景与短信签名、模板、参数的映射
     *
     * @param smsSendForm
     * @return
     */
    public SmsTemplateAndParams getSmsParam(SmsSendForm smsSendForm, AuthenticationInfo authenticationInfo) {
        throw new ApplicationException(ResponseCode.SYSTEM_ERROR, "未配置短信场景与短信签名、模板、参数的映射");
    }

    public Boolean isSuperAdmin(AuthenticationInfo authenticationInfo) {
        return true;
    }
}
