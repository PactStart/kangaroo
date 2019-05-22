package io.github.pactstart.jpush.autoconfigure;

import cn.jpush.api.JPushClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(annotation = EnableJPush.class)
@EnableConfigurationProperties(JPushProperties.class)
public class JPushAutoConfiguration implements InitializingBean {

    @Autowired
    private JPushProperties jPushProperties;

    private JPushService jPushService;

    @Bean
    public JPushService jPushService() {
        return jPushService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        JPushClient jPushClient = new JPushClient(jPushProperties.getMasterSecret(), jPushProperties.getAppKey());
        jPushService = new JPushService(jPushClient, jPushProperties.isProduction(), jPushProperties.getName());
    }
}
