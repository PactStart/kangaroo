package io.github.pactstart.mq.serializer;

import com.alibaba.fastjson.JSON;
import io.github.pactstart.mq.message.MQMessage;

public class JsonSerializer implements MessageSerializer<MQMessage> {

    @Override
    public byte[] serialize(MQMessage obj) {
        return JSON.toJSONString(obj).getBytes();
    }

    @Override
    public MQMessage deserialize(byte[] bytes, Class<? extends MQMessage> clazz) {
        return JSON.parseObject(bytes, clazz);
    }
}