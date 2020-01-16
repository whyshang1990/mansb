package com.why.first.mansb.exception;

import com.why.first.mansb.dto.response.CodeMsgEnum;

public class AppRuntimeException extends RuntimeException {
    private CodeMsgEnum codeMsg;

    public AppRuntimeException(CodeMsgEnum codeMsg) {
        this.codeMsg = codeMsg;
    }

    public AppRuntimeException(String message, CodeMsgEnum codeMsg) {
        super(message);
        this.codeMsg = codeMsg;
    }

    public AppRuntimeException(String message, Throwable cause, CodeMsgEnum codeMsg) {
        super(message, cause);
        this.codeMsg = codeMsg;
    }

    public AppRuntimeException(Throwable cause, CodeMsgEnum codeMsg) {
        super(cause);
        this.codeMsg = codeMsg;
    }

    public CodeMsgEnum getCodeMsg() {
        return codeMsg;
    }
}
