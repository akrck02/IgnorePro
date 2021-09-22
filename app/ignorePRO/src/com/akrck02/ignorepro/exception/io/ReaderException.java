package com.akrck02.ignorepro.exception.io;

import com.akrck02.ignorepro.exception.IgnoreProRuntimeException;

public class ReaderException extends IgnoreProRuntimeException {

    public ReaderException() {
    }

    public ReaderException(String message) {
        super(message);
    }

    public ReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReaderException(Throwable cause) {
        super(cause);
    }
}
