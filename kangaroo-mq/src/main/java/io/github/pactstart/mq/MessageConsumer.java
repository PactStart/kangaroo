package io.github.pactstart.mq;

import io.github.pactstart.mq.message.MQMessage;

public interface MessageConsumer<T extends MQMessage> {

    /**
     * 接收并处理订阅消息
     *
     * @param message 消息
     */
    void consume(T message);

}

