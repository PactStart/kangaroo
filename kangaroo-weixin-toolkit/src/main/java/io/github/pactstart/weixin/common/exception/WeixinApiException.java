package io.github.pactstart.weixin.common.exception;

/**
 * Created by Rex.Lei on 2017/7/26.
 */
public class WeixinApiException extends RuntimeException {

    public WeixinApiException(String message) {
        super(message);
    }

    public WeixinApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
