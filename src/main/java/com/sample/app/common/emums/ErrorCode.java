package com.sample.app.common.emums;

public enum ErrorCode {

    CR100("Customer not found"),
    CR200("Customer Already Exist");

    private String msg;

    ErrorCode(String msg) {
        this.msg = msg;
    }

    public String getMsg(){
        return this.msg;
    }

}
