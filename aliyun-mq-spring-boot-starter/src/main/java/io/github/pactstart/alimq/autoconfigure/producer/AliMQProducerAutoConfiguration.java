package io.github.pactstart.alimq.autoconfigure.producer;

import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import io.github.pactstart.mq.serializer.JsonSerializer;
import io.github.pactstart.mq.serializer.MessageSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@ConditionalOnBean(annotation = EnableAliMQProducer.class)
@EnableConfigurationProperties(AliMQProducerProperties.class)
public class AliMQProducerAutoConfiguration {

    @Autowired
    private AliMQProducerProperties properties;

    @Bean(initMethod = "start", destroyMethod = "shutdown")
    public Producer producer() {
        Properties mqProperties = new Properties();
        //您在控制台创建的 Producer ID
        mqProperties.put(PropertyKeyConst.ProducerId, properties.getProducerId());
        // AccessKey 阿里云身份验证，在阿里云服务器管理控制台创建
        mqProperties.put(PropertyKeyConst.AccessKey, properties.getAccessKeyId());
        // SecretKey 阿里云身份验证，在阿里云服务器管理控制台创建
        mqProperties.put(PropertyKeyConst.SecretKey, properties.getAccessKeySecret());
        //设置发送超时时间，单位毫秒
        mqProperties.put(PropertyKeyConst.SendMsgTimeoutMillis, "10000");
        // 设置 TCP 接入域名（此处以公共云生产环境为例）
        mqProperties.put(PropertyKeyConst.ONSAddr,
                "http://onsaddr-internet.aliyun.com/rocketmq/nsaddr4client-internet");

        Producer producer = ONSFactory.createProducer(mqProperties);

        return producer;
    }

    @ConditionalOnProperty(name = "aliyun.mq.producer.serializeType", havingValue = "json", matchIfMissing = true)
    @Bean("producerMessageSerializer")
    public MessageSerializer messageSerializer() {
        return new JsonSerializer();
    }

    @Bean
    public AliMessageProducer messageProducer(Producer producer, @Qualifier("producerMessageSerializer") MessageSerializer messageSerializer) {
        return new AliMessageProducer(producer, messageSerializer, properties.getTopic());
    }
}
