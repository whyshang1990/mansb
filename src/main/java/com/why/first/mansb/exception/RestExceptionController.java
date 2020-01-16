package com.why.first.mansb.exception;

import com.why.first.mansb.constant.CommonConstant;
import com.why.first.mansb.dto.response.BaseResponse;
import com.why.first.mansb.utils.ResponseUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class RestExceptionController {
    @ExceptionHandler(AppRuntimeException.class)
    @ResponseBody
    public final BaseResponse<String> handleAppExceptions(AppRuntimeException ex) {
        return ResponseUtil.exception(ex);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public final BaseResponse<String> handleExceptions(Exception ex) {
        return ResponseUtil.innerError();
    }
}
