package com.why.first.mansb.dto.response;

public enum CodeMsg {
    SUCCESS(0, "success"),
    APP_EXCEPTION(10000, "Exception Information");
    private int code;
    private String msg;

    CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
