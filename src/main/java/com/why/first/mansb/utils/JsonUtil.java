package com.why.first.mansb.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.why.first.mansb.dto.response.CodeMsgEnum;
import com.why.first.mansb.exception.AppRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            LOGGER.error("Json 解析异常");
            ex.printStackTrace();
            throw new AppRuntimeException(CodeMsgEnum.TRANSFORM_JSON_FAILED);
        }
    }
}
