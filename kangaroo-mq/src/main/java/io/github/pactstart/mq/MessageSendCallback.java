package io.github.pactstart.mq;

public interface MessageSendCallback {

    void onSuccess(MessageSendResult sendResult);

    void onException(MessageSendException exception);
}
