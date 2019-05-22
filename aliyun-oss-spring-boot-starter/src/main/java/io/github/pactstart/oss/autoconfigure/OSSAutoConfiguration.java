package io.github.pactstart.oss.autoconfigure;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(OssConfig.class)
public class OSSAutoConfiguration implements InitializingBean {

    @Autowired
    private OssConfig ossConfig;

    private OssClient ossClient;

    @Bean
    public OssClient ossClient(OssConfig ossConfig) {
        return ossClient;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.ossClient = new OssClient(ossConfig);
    }
}
