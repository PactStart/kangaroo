package io.github.pactstart.simple.web.framework.encrypt.springboot.autoconfigure;

import io.github.pactstart.simple.web.framework.encrypt.algorithm.EncryptAlgorithm;
import io.github.pactstart.simple.web.framework.encrypt.core.EncryptFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties(EncryptConfig.class)
public class EncryptAutoConfiguration {

    @Autowired
    private EncryptConfig encryptConfig;

    @Autowired(required = false)
    private EncryptAlgorithm encryptAlgorithm;

    @Bean
    public FilterRegistrationBean filterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new EncryptFilter(encryptConfig, encryptAlgorithm));
        registration.setUrlPatterns(encryptConfig.getUrlPatternList());
        registration.setName("EncryptFilter");
        registration.setOrder(5);
        return registration;
    }

    @Bean
    public EncryptApiScanner apiEncryptDataInit() {
        return new EncryptApiScanner();
    }
}
