package com.service;

import com.model.Config;
import org.springframework.stereotype.Service;

@Service
public interface ConfigureService {
    /*给一个config对象 存入db*/
     void addConfigure(Config config);
}
