package com.why.first.mansb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {
    private static Logger LOGGER = LoggerFactory.getLogger(Example.class);

    @GetMapping("/home")
    public String home() {
        LOGGER.debug("打印日志");
        LOGGER.info("打印日志");
        return "你好, Spring Boot";
    }

    public static void main(String[] args) {
        LOGGER.debug("this is debug");
        LOGGER.info("this is info");
        LOGGER.error("this is error");
    }
}
