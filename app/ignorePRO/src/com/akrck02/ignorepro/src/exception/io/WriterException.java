package com.akrck02.ignorepro.src.exception.io;

import com.akrck02.ignorepro.src.exception.IgnoreProRuntimeException;

public class WriterException extends IgnoreProRuntimeException {
    public WriterException() {
    }

    public WriterException(String message) {
        super(message);
    }

    public WriterException(String message, Throwable cause) {
        super(message, cause);
    }

    public WriterException(Throwable cause) {
        super(cause);
    }
}
