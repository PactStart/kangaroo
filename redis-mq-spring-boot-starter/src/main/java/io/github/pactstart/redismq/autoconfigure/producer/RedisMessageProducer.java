package io.github.pactstart.redismq.autoconfigure.producer;

import io.github.pactstart.mq.MessageProducer;
import io.github.pactstart.mq.MessageSendCallback;
import io.github.pactstart.mq.anotation.MessageChannel;
import io.github.pactstart.mq.message.MQMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisMessageProducer implements MessageProducer {

    private static Logger log = LoggerFactory.getLogger(RedisMessageProducer.class);

    private RedisTemplate<String, String> redisTemplate;

    public RedisMessageProducer(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void send(MQMessage message) {
        Class<?> clazz = message.getClass();
        if (!clazz.isAnnotationPresent(MessageChannel.class)) {
            log.error("MessageChannel annotation don't present in class {} , cannot send message", clazz.getName());
            return;
        }
        String topic = clazz.getAnnotation(MessageChannel.class).value();
        redisTemplate.convertAndSend(topic, message);
    }

    @Override
    public void sendAsync(MQMessage message, MessageSendCallback callback) {
        send(message);
    }

    @Override
    public void sendOneWay(MQMessage message) {
        send(message);
    }

}
