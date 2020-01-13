package com.why.first.mansb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {
    @GetMapping("/home")
    public String home() {
        return "你好, Spring Boot";
    }
}
