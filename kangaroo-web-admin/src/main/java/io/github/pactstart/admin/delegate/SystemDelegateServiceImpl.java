package io.github.pactstart.admin.delegate;

import io.github.pactstart.system.component.ConfigComponent;
import io.github.pactstart.system.delegate.SystemDelegateService;

public class SystemDelegateServiceImpl implements SystemDelegateService {

    private ConfigComponent configComponent;

    public SystemDelegateServiceImpl(ConfigComponent configComponent) {
        this.configComponent = configComponent;
    }

    @Override
    public boolean isRealSendSms() {
        return configComponent.getBooleanProperty("system", "isRealSendSms", true);
//        return SpringContextHolder.getCurrentEnv() == Env.prod;
    }

    @Override
    public boolean isValidateSmsSendParam() {
        return true;
    }
}
