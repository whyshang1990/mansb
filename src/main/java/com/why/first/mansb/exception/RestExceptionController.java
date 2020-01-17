package com.why.first.mansb.exception;

import com.why.first.mansb.dto.response.BaseResponse;
import com.why.first.mansb.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class RestExceptionController {
    private final static Logger LOGGER = LoggerFactory.getLogger(RestExceptionController.class);

    @ExceptionHandler(AppRuntimeException.class)
    @ResponseBody
    public final BaseResponse<String> handleAppExceptions(AppRuntimeException ex) {
        LOGGER.error(ex.getMessage());
        return ResponseUtil.exception(ex);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public final BaseResponse<Object> handleExceptions(Exception ex) {
        LOGGER.error(ex.getMessage());
        return ResponseUtil.innerError();
    }
}
