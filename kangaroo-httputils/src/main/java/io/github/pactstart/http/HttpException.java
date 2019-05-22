package io.github.pactstart.http;

public class HttpException extends RuntimeException {

    private static final long serialVersionUID = 895529979147144397L;

    public HttpException(String message) {
        super(message);
    }

    public HttpException(Throwable e) {
        super(e);
    }

}
