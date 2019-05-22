package io.github.pactstart.service.dispatcher.exception;

import io.github.pactstart.biz.common.errorcode.ResponseCode;

public class ServiceApiException extends RuntimeException {

    private ResponseCode responseCode;

    public ServiceApiException(ResponseCode responseCode) {
        super(responseCode.getMsg());
        this.responseCode = responseCode;
    }

    public ServiceApiException(ResponseCode responseCode, String message) {
        super(message);
        this.responseCode = new ResponseCode(responseCode.getCode(), message);
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }
}
