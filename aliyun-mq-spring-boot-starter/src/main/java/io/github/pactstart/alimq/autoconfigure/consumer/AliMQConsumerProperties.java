package io.github.pactstart.alimq.autoconfigure.consumer;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "aliyun.mq.listener")
public class AliMQConsumerProperties {

    private String topic;

    private String consumerId;

    private String accessKeyId;

    private String accessKeySecret;

    private int consumeThreads = 5;

    private String serializeType = "json";

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public int getConsumeThreads() {
        return consumeThreads;
    }

    public void setConsumeThreads(int consumeThreads) {
        this.consumeThreads = consumeThreads;
    }

    public String getSerializeType() {
        return serializeType;
    }

    public void setSerializeType(String serializeType) {
        this.serializeType = serializeType;
    }

}
