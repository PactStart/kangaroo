package io.github.pactstart.biz.common.exception;

import io.github.pactstart.biz.common.errorcode.ResponseCode;

public class ApplicationException extends RuntimeException {

    private ResponseCode responseCode;

    private Throwable sourceException;

    public ApplicationException() {
        //默认系统错误
        responseCode = ResponseCode.SYSTEM_ERROR;
    }

    public ApplicationException(ResponseCode responseCode) {
        super(responseCode.getMsg());
        this.responseCode = responseCode;
    }

    public ApplicationException(ResponseCode responseCode, String message) {
        super(message);
        this.responseCode = new ResponseCode(responseCode.getCode(), message);
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public Throwable getSourceException() {
        return sourceException;
    }

    public void setSourceException(Throwable sourceException) {
        this.sourceException = sourceException;
    }
}
