package com.why.first.mansb.utils;

import com.why.first.mansb.constant.CommonConstant;
import com.why.first.mansb.dto.response.BaseResponse;
import com.why.first.mansb.dto.response.CodeMsgEnum;
import com.why.first.mansb.exception.AppRuntimeException;

public class ResponseUtil {
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(CodeMsgEnum.SUCCESS, data);
    }

    public static BaseResponse<Object> success() {
        return success(CommonConstant.NULL);
    }

    public static BaseResponse<Object> innerError() {
        return new BaseResponse<>(CodeMsgEnum.ERROR, CommonConstant.NULL);
    }

    public static BaseResponse<String> exception(AppRuntimeException ex) {
        return new BaseResponse<>(ex.getCodeMsg(), CommonConstant.NULL);
    }
}
