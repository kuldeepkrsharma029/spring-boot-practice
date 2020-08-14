package com.sample.app.dto;

import com.sample.app.common.emums.ErrorCode;

import java.io.Serializable;

public class ErrorResponseDTO implements Serializable {

    private String errorMsg;

    private ErrorCode errorCode;

    public ErrorResponseDTO() {
        super();
    }

    public ErrorResponseDTO(String errorMsg, ErrorCode errorCode) {
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
