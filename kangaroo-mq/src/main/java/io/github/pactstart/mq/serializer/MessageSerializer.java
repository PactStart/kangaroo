package io.github.pactstart.mq.serializer;

import io.github.pactstart.mq.message.MQMessage;

public interface MessageSerializer<T extends MQMessage> {

    byte[] serialize(T obj);

    T deserialize(byte[] bytes, Class<? extends T> clazz);
}
