package com.why.first.mansb.config;

import ch.qos.logback.core.PropertyDefinerBase;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class LogHomeConfig extends PropertyDefinerBase {
    public static final String LOG_DIR = File.separator +  "logs";

    @Override
    public String getPropertyValue() {
        String path = System.getProperty("user.dir");
        return path + LOG_DIR;
    }
}
