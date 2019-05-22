package io.github.pactstart.rong360.autoconfigure;

import io.github.pactstart.rong360.openapi.DefaultRong360Client;
import io.github.pactstart.rong360.openapi.Rong360Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(annotation = EnableRong360Api.class)
@EnableConfigurationProperties(Rong360Config.class)
public class Rong360AutoConfiguration {

    @Autowired
    private Rong360Config rong360Config;

    @Bean
    public Rong360Client rong360Client() {
        return new DefaultRong360Client(rong360Config);
    }
}
