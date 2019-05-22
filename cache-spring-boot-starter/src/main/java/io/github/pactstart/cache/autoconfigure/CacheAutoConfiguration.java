package io.github.pactstart.cache.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@EnableConfigurationProperties(CacheConfig.class)
@Configuration
public class CacheAutoConfiguration {

    @Autowired
    private CacheConfig cacheConfig;

    @ConditionalOnProperty(prefix = "application.cache", name = "cacheType", havingValue = "spring-data-redis")
    @Bean
    public CacheService redisCacheService(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, String> template = new RedisTemplate();
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setDefaultSerializer(new CustomRedisSerializer<>());
        template.setConnectionFactory(connectionFactory);
        template.afterPropertiesSet();
        return new RedisCacheServiceImpl(template);
    }
}
