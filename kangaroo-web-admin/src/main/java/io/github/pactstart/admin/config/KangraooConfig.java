package io.github.pactstart.admin.config;

import io.github.pactstart.admin.adpater.KangarooWebAdapter;
import io.github.pactstart.admin.delegate.SystemDelegateServiceImpl;
import io.github.pactstart.system.component.ConfigComponent;
import io.github.pactstart.system.delegate.SystemDelegateService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KangraooConfig {

    @ConditionalOnMissingBean(KangarooWebAdapter.class)
    @Bean
    public KangarooWebAdapter kangarooWebAdapter() {
        return new KangarooWebAdapter();
    }

    @ConditionalOnMissingBean(SystemDelegateService.class)
    @Bean
    public SystemDelegateService systemDelegateService(ConfigComponent configComponent) {
        return new SystemDelegateServiceImpl(configComponent);
    }
}
