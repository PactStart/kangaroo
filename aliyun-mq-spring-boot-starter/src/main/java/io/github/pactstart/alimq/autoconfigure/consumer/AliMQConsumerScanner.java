package io.github.pactstart.alimq.autoconfigure.consumer;

import com.aliyun.openservices.ons.api.*;
import io.github.pactstart.mq.MessageConsumer;
import io.github.pactstart.mq.anotation.MessageChannel;
import io.github.pactstart.mq.message.MQMessage;
import io.github.pactstart.mq.serializer.JsonSerializer;
import io.github.pactstart.mq.serializer.MessageSerializer;
import io.github.pactstart.mq.utils.MessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.ParameterizedType;
import java.util.*;

/**
 * 扫描Spring容器中所有实现了MessageConsumer的Bean,建立channel--consumer映射关系
 */
@Configuration
@ConditionalOnBean(annotation = EnableAliMQConsumer.class)
@EnableConfigurationProperties(AliMQConsumerProperties.class)
public class AliMQConsumerScanner implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(AliMQConsumerScanner.class);

    private MessageSerializer<MQMessage> serializer;

    private Map<String, List<MessageConsumer<? extends MQMessage>>> channelConsumerMapping = new HashMap<>();

    private Map<String, Class<? extends MQMessage>> consumerMessageTypeMapping = new HashMap<>();

    @Autowired
    private AliMQConsumerProperties mqConsumerProperties;

    @ConditionalOnProperty(name = "aliyun.mq.consumer.serializeType", havingValue = "json", matchIfMissing = true)
    @Bean("consumerMessageSerializer")
    public MessageSerializer messageSerializer() {
        this.serializer = new JsonSerializer();
        return serializer;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, MessageConsumer> messageConsumerMap = applicationContext.getBeansOfType(MessageConsumer.class);
        for (MessageConsumer consumer : messageConsumerMap.values()) {
            //获取第一个泛型参数的Class对象
            ParameterizedType type = (ParameterizedType) consumer.getClass().getGenericInterfaces()[0];
            Class<MQMessage> clazz = (Class<MQMessage>) type.getActualTypeArguments()[0];
            //从Class对象中获取该消息消费者监听的topic和tag
            MessageChannel channel = MessageUtils.getMessageChannel(clazz);

            if (channelConsumerMapping.containsKey(channel.value())) {
                channelConsumerMapping.get(channel.value()).add(consumer);
            } else {
                List<MessageConsumer<? extends MQMessage>> consumerList = new ArrayList<>();
                consumerList.add(consumer);
                channelConsumerMapping.put(channel.value(), consumerList);
            }
            consumerMessageTypeMapping.put(consumer.getClass().getName(), clazz);
        }

    }


    private String getTagExp() {
        Set<String> channelSet = channelConsumerMapping.keySet();
        StringBuilder sb = new StringBuilder();
        for (String channel : channelSet) {
            sb.append(" || ").append(channel);
        }
        String tagExp = sb.delete(0, 4).toString();
        return tagExp;
    }


    public void subscribe(Consumer consumer) {
        consumer.subscribe(mqConsumerProperties.getTopic(), getTagExp(), new MessageListener() { //订阅多个 Tag
            public Action consume(Message onsMsg, ConsumeContext context) {
                try {
                    if (channelConsumerMapping.containsKey(onsMsg.getTag())) {
                        //根据tag获取consumer
                        List<MessageConsumer<? extends MQMessage>> consumerList = channelConsumerMapping.get(onsMsg.getTag());
                        for (MessageConsumer messageConsumer : consumerList) {
                            //获取consumer消费的消息类型，并将接收到的消息转换为该类型
                            MQMessage mqMessage = serializer.deserialize(onsMsg.getBody(), consumerMessageTypeMapping.get(messageConsumer.getClass().getName()));
                            mqMessage.setKey(onsMsg.getKey());
                            //消费消息
                            messageConsumer.consume(mqMessage);
                        }
                    } else {
                        logger.error("Received a message but no consumer ,topic : {},tag : {}", onsMsg.getTopic(), onsMsg.getTag());
                    }

                    return Action.CommitMessage;
                } catch (Exception e) {
                    if (e instanceof ClassCastException) {
                        logger.error("消息类型不匹配，稍后重新消费：" + e.getMessage());
                        return Action.ReconsumeLater;
                    } else {
                        logger.error("消息处理异常，稍后重新消费：", e);
                        return Action.ReconsumeLater;
                    }
                }
            }
        });

    }
}
