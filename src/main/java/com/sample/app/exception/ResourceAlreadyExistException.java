package com.sample.app.exception;

import com.sample.app.common.emums.ErrorCode;

public class ResourceAlreadyExistException  extends RuntimeException {

    private ErrorCode errorCode;

    public ResourceAlreadyExistException(String msg, ErrorCode errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }
}