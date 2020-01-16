package com.why.first.mansb.dto.response;

public enum CodeMsgEnum {
    SUCCESS(1, "Success"),
    ERROR(0, "Unknown Inner Error"),

    APP_EXCEPTION(10000, "Exception Information");
    private int code;
    private String msg;

    CodeMsgEnum(int code, String msg) {
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
