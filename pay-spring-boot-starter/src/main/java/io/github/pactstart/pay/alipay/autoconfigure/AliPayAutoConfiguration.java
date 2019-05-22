package io.github.pactstart.pay.alipay.autoconfigure;

import io.github.pactstart.pay.alipay.AliPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(annotation = EnableAliPay.class)
@EnableConfigurationProperties(AliPayConfig.class)
public class AliPayAutoConfiguration {

    @Autowired
    private AliPayConfig aliPayConfig;

    @Bean
    public AliPayService aliPayService() {
        return new AliPayService(aliPayConfig);
    }

}
