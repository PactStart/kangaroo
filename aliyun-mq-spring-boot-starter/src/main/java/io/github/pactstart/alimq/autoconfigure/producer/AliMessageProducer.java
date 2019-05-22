package io.github.pactstart.alimq.autoconfigure.producer;

import com.aliyun.openservices.ons.api.*;
import io.github.pactstart.mq.MessageProducer;
import io.github.pactstart.mq.MessageSendCallback;
import io.github.pactstart.mq.MessageSendException;
import io.github.pactstart.mq.MessageSendResult;
import io.github.pactstart.mq.anotation.MessageChannel;
import io.github.pactstart.mq.message.MQMessage;
import io.github.pactstart.mq.serializer.MessageSerializer;
import io.github.pactstart.mq.utils.MessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AliMessageProducer implements MessageProducer {

    public final static long MSG_MAX_STORE_TIME = 39L * 24L * 60L * 60L * 1000L;

    private static final Logger logger = LoggerFactory.getLogger(AliMessageProducer.class);

    private Producer producer;

    private MessageSerializer<MQMessage> messageSerializer;

    private String topic;

    public AliMessageProducer(Producer producer, MessageSerializer<MQMessage> messageSerializer, String topic) {
        this.producer = producer;
        this.messageSerializer = messageSerializer;
        this.topic = topic;
    }

    @Override
    public void send(MQMessage message) {
        Message onsMsg = createONSMessage(message);
        producer.send(onsMsg);
    }

    @Override
    public void sendOneWay(MQMessage message) {
        Message onsMsg = createONSMessage(message);
        producer.sendOneway(onsMsg);
    }

    @Override
    public void sendAsync(MQMessage message, final MessageSendCallback callback) {
        Message onsMsg = createONSMessage(message);
        producer.sendAsync(onsMsg, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                MessageSendResult messageSendResult = new MessageSendResult();
                messageSendResult.setMessageId(sendResult.getMessageId());
                messageSendResult.setTopic(sendResult.getTopic());
                callback.onSuccess(messageSendResult);
            }

            @Override
            public void onException(OnExceptionContext onExceptionContext) {
                MessageSendException exception = new MessageSendException(onExceptionContext.getException());
                exception.setMessageId(onExceptionContext.getMessageId());
                exception.setTopic(onExceptionContext.getTopic());
                callback.onException(exception);
            }
        });
    }

    /**
     * 转化为ONS消息
     *
     * @param message
     * @return
     */
    private Message createONSMessage(MQMessage message) {
        Long deliverTime = message.getDeliverTime();
        MessageChannel channel = MessageUtils.getMessageChannel(message.getClass());
        if (deliverTime != null) {
            // 判断是否
            long currMillis = System.currentTimeMillis();
            if (deliverTime - currMillis > MSG_MAX_STORE_TIME) {
                deliverTime = currMillis + MSG_MAX_STORE_TIME;
            } else {
                message.setDeliverTime(null); //设置为null,不序列化
            }
        }
        String key = message.getKey();
        message.setKey(null); //设置为null,不序列化
        Message onsMsg = new Message(this.topic, channel.value(), key, messageSerializer.serialize(message));
        if (deliverTime != null) {
            onsMsg.setStartDeliverTime(deliverTime);
        }
        return onsMsg;
    }

    public void start() {
        if (!producer.isStarted()) {
            producer.start();
        }
    }

    public void stop() {
        if (!producer.isClosed()) {
            producer.shutdown();
        }
    }
}
