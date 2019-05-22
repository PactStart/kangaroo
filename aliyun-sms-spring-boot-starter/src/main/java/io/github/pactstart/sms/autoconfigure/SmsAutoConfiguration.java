package io.github.pactstart.sms.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SmsConfig.class)
public class SmsAutoConfiguration {

    @Autowired
    private SmsConfig smsConfig;

    @Bean
    public SmsClient smsClient() {
        return new SmsClient(smsConfig);
    }
}
