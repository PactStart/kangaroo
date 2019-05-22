package io.github.pactstart.weixin.autoconfigure;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(WeixinOpenProperties.class)
public class WeixinAutoConfiguration {

}
