package com.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Path {
    @Value("${com.img.path}")
    public    String imgPath;
    @Value("com.log.logger")
    public  String tipLog;
}
