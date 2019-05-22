package io.github.pactstart.system.facade;

import io.github.pactstart.system.facade.dto.*;

public interface SmsServiceFacade {

    /**
     * 发送通知短信
     *
     * @param smsSendParamDto
     * @return
     */
    SmsSendResultDto sendNoticeSms(SmsSendParamDto smsSendParamDto);

    /**
     * 发送验证短信
     *
     * @param smsSendParamDto
     * @return
     */
    SmsSendResultDto sendValidateSms(SmsSendParamDto smsSendParamDto);

    /**
     * 验证短信验证码是否正确
     *
     * @param smsCodeValidateParamDto
     * @return
     */
    SmsCodeValidateResultDto validateSmsCode(SmsCodeValidateParamDto smsCodeValidateParamDto);

    /**
     * 移除短信验证码
     *
     * @param smsCodeRemoveDto
     */
    void removeSmsCode(SmsCodeRemoveDto smsCodeRemoveDto);
}
