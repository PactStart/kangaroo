package io.github.pactstart.chuanglan.autoconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ChuangLanConfig.class)
public class ChuangLanSmsAutoConfiguration {

    @Autowired
    private ChuangLanConfig chuangLanConfig;

    @Bean
    public ChuangLanSmsClient smsClient() {
        return new ChuangLanSmsClient(chuangLanConfig);
    }
}
