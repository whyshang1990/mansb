package com.why.first.mansb.exception;

import com.why.first.mansb.dto.response.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class RestExceptionController {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public final BaseResponse<String> handleExceptions(Exception ex) {
        return new BaseResponse<>(99999, ex.getMessage());
    }
}
