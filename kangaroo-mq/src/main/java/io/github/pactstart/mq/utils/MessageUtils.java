package io.github.pactstart.mq.utils;

import io.github.pactstart.mq.anotation.MessageChannel;
import io.github.pactstart.mq.message.MQMessage;

public class MessageUtils {

    public static MessageChannel getMessageChannel(Class<? extends MQMessage> clazz) {
        return clazz.getAnnotation(MessageChannel.class);
    }
}
