package io.github.pactstart.redismq.autoconfigure.producer;

import io.github.pactstart.mq.MessageProducer;
import io.github.pactstart.redismq.autoconfigure.serializer.CustomRedisSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@ConditionalOnBean(annotation = EnableRedisMQProducer.class)
public class RedisMQProducerAutoConfiguration {

    @Bean
    public MessageProducer messageProducer(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, String> template = new RedisTemplate();
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setDefaultSerializer(new CustomRedisSerializer<>());
        template.setConnectionFactory(connectionFactory);
        template.afterPropertiesSet();
        return new RedisMessageProducer(template);
    }
}
