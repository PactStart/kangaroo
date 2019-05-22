package io.github.pactstart.redismq.autoconfigure.consumer;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import io.github.pactstart.mq.MessageConsumer;
import io.github.pactstart.mq.anotation.MessageChannel;
import io.github.pactstart.mq.message.MQMessage;
import io.github.pactstart.redismq.autoconfigure.serializer.CustomRedisSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Configuration
@ConditionalOnBean(annotation = EnableRedisMQConsumer.class)
public class MessageConsumerScannerListener extends MessageListenerAdapter implements ApplicationContextAware {

    private static final Logger log = LoggerFactory.getLogger(MessageConsumerScannerListener.class);

    private Multimap<String, MessageConsumer> topicConsumerListMap = ArrayListMultimap.create();

    public MessageConsumerScannerListener() {
        super();
        super.setStringSerializer(new StringRedisSerializer());
        super.setSerializer(new CustomRedisSerializer<>());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, MessageConsumer> messageConsumerMap = applicationContext.getBeansOfType(MessageConsumer.class);
        for (MessageConsumer consumer : messageConsumerMap.values()) {
            //获取第一个泛型参数的Class对象
            ParameterizedType type = (ParameterizedType) consumer.getClass().getGenericInterfaces()[0];
            Class<?> clazz = (Class<?>) type.getActualTypeArguments()[0];
            if (!clazz.isAnnotationPresent(MessageChannel.class)) {
                log.error("MessageChannel annotation don't present in class {} , consumer {} will be ignored!", clazz.getName(), consumer.getClass().getName());
                return;
            }
            String topic = clazz.getAnnotation(MessageChannel.class).value();
            topicConsumerListMap.put(topic, consumer);
        }
    }

    public List<PatternTopic> getTopics() {
        Set<String> topicSet = topicConsumerListMap.keySet();
        List<PatternTopic> topicList = Lists.newArrayList();
        for (String topic : topicSet) {
            topicList.add(new PatternTopic(topic));
        }
        return topicList;
    }

    public void handleMessage(Object convertedMessage, String convertedChannel) {
        Collection<MessageConsumer> messageConsumers = topicConsumerListMap.get(convertedChannel);
        for (MessageConsumer consumer : messageConsumers) {
            consumer.consume((MQMessage) convertedMessage);
        }
    }

}
