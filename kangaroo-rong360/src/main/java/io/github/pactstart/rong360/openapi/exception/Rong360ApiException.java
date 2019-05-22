package io.github.pactstart.rong360.openapi.exception;

public class Rong360ApiException extends RuntimeException {

    public Rong360ApiException() {
    }

    public Rong360ApiException(String message) {
        super(message);
    }

    public Rong360ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
