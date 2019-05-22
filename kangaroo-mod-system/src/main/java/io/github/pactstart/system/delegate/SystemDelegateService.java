package io.github.pactstart.system.delegate;

/**
 * please implements this interface and inject into spring context
 */
public interface SystemDelegateService {

    /**
     * 是否真实发送短信
     */
    boolean isRealSendSms();

    /**
     * 是否校验短信发送参数，例如短信参数合法或多余
     *
     * @return
     */
    boolean isValidateSmsSendParam();
}
