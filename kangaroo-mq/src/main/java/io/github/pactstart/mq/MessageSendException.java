package io.github.pactstart.mq;

public class MessageSendException extends RuntimeException {

    private Exception internalException;

    private String messageId;

    private String topic;

    public MessageSendException(Exception internalException) {
        super(internalException);
    }

    public Exception getInternalException() {
        return internalException;
    }

    public void setInternalException(Exception internalException) {
        this.internalException = internalException;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
