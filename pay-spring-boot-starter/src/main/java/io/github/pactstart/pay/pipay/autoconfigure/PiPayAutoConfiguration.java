package io.github.pactstart.pay.pipay.autoconfigure;

import io.github.pactstart.pay.pipay.PiPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(annotation = EnablePiPay.class)
@EnableConfigurationProperties(PiPayConfig.class)
public class PiPayAutoConfiguration {

    @Autowired
    private PiPayConfig piPayConfig;

    @Bean
    public PiPayService piPayService() {
        return new PiPayService(piPayConfig);
    }
}
