package com.why.first.mansb.dto.response;

public enum CodeMsgEnum {
    SUCCESS(1, "Success"),
    ERROR(0, "Unknown Inner Error"),

    // 用户异常
    USER_INFO_ERROR(10000, "Username or password is error"),
    USER_AUTH_FAILED(10001, "User Authentication Failed"),

    // 内部异常
    TRANSFORM_JSON_FAILED(80000, "transform json failed"),

    APP_EXCEPTION(99999, "Exception Information");
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
