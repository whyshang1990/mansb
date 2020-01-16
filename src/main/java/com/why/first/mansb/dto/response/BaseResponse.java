package com.why.first.mansb.dto.response;

public class BaseResponse<T> {
    private int code;
    private String msg;
    private T data;

    public BaseResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse(int code, String msg) {
        this(code, msg, null);
    }

    public BaseResponse(CodeMsgEnum codeMsgEnum, T data) {
        this(codeMsgEnum.getCode(), codeMsgEnum.getMsg(), data);
    }

    public BaseResponse(CodeMsgEnum codeMsgEnum) {
        this(codeMsgEnum, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
