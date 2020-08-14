package com.sample.app.exception;

import com.sample.app.common.emums.ErrorCode;

public class CustomerResourceNotFoundException extends RuntimeException {

    private ErrorCode errorCode;

    public CustomerResourceNotFoundException(String msg, ErrorCode errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }
}
