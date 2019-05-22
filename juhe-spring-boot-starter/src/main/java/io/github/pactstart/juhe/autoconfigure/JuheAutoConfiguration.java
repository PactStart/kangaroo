package io.github.pactstart.juhe.autoconfigure;

import com.alibaba.fastjson.JSON;
import io.github.pactstart.juhe.request.JuheDefaultRequest;
import io.github.pactstart.juhe.service.JuheService;
import io.github.pactstart.juhe.service.impl.JuheServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(JuheProperties.class)
public class JuheAutoConfiguration implements InitializingBean {
    @Autowired
    private JuheProperties juheProperties;

    private Logger logger = LoggerFactory.getLogger(JuheAutoConfiguration.class);

    private JuheService juheService;

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("Juhe config：{}" + JSON.toJSONString(juheProperties));
        JuheDefaultRequest.setJuheProperties(juheProperties);
        juheService = new JuheServiceImpl();
    }

    @Bean
    public JuheService juheService() {
        return juheService;
    }
}
