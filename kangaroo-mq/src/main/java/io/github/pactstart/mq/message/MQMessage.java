package io.github.pactstart.mq.message;

public abstract class MQMessage {

    /**
     * 如果采用阿里云消息队列服务，请设置key尽可能全局唯一（业务关键属性），以方便您在无法正常收到消息情况下，可通过阿里云服务器管理控制台查询消息并补发
     * 注意：不设置也不会影响消息正常收发
     */
    private String key;

    /**
     * 消息投递时间 ，为空则为即时投递
     */
    private Long deliverTime;

    public String getKey() {
        return key == null || key.trim().equals("") ? "" : key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Long deliverTime) {
        this.deliverTime = deliverTime;
    }
}
