package io.github.pactstart.alimq.autoconfigure.consumer;

import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@ConditionalOnBean(annotation = {EnableAliMQConsumer.class})
@EnableConfigurationProperties({AliMQConsumerProperties.class})
@AutoConfigureAfter({AliMQConsumerScanner.class})
public class AliMQConsumerAutoConfiguration {

    @Autowired
    private AliMQConsumerProperties mqConsumerProperties;

    @Autowired
    private AliMQConsumerScanner scanner;

    @Bean(initMethod = "start", destroyMethod = "shutdown")
    public Consumer consumer() {
        Properties properties = new Properties();
        // 您在控制台创建的 Consumer ID
        properties.put(PropertyKeyConst.ConsumerId, mqConsumerProperties.getConsumerId());
        // AccessKey 阿里云身份验证，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.AccessKey, mqConsumerProperties.getAccessKeyId());
        // SecretKey 阿里云身份验证，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.SecretKey, mqConsumerProperties.getAccessKeySecret());
        // 设置 TCP 接入域名（此处以公共云生产环境为例）
        properties.put("ConsumeThreadNums", this.mqConsumerProperties.getConsumeThreads());
        // 集群订阅方式 (默认)
        // properties.put(PropertyKeyConst.MessageModel, PropertyValueConst.CLUSTERING);
        // 广播订阅方式
        // properties.put(PropertyKeyConst.MessageModel, PropertyValueConst.BROADCASTING);
        Consumer consumer = ONSFactory.createConsumer(properties);

        //消费者订阅topic和tag
        scanner.subscribe(consumer);

        return consumer;
    }

}
