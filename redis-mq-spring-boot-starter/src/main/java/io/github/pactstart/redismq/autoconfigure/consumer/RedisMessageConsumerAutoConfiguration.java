package io.github.pactstart.redismq.autoconfigure.consumer;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

@Configuration
@ConditionalOnBean(annotation = EnableRedisMQConsumer.class)
@AutoConfigureAfter(MessageConsumerScannerListener.class)
public class RedisMessageConsumerAutoConfiguration {

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageConsumerScannerListener scannerListener) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(scannerListener, scannerListener.getTopics());
        return container;
    }
}
