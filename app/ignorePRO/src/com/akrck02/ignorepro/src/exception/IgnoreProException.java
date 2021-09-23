package com.akrck02.ignorepro.src.exception;

public class IgnoreProException extends Exception{
    public IgnoreProException() {
        super();
    }

    public IgnoreProException(String message) {
        super(message);
    }

    public IgnoreProException(String message, Throwable cause) {
        super(message, cause);
    }

    public IgnoreProException(Throwable cause) {
        super(cause);
    }
}
