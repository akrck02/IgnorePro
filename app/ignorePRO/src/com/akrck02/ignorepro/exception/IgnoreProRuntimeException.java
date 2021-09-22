package com.akrck02.ignorepro.exception;

public class IgnoreProRuntimeException extends RuntimeException{
    public IgnoreProRuntimeException() {
        super();
    }

    public IgnoreProRuntimeException(String message) {
        super(message);
    }

    public IgnoreProRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IgnoreProRuntimeException(Throwable cause) {
        super(cause);
    }
}
