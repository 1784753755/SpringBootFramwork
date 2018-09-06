package com.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    static Logger logger;
/*    public static Logger logger = LogManager.getLogger(ProductResController.class);*/
    public  static  Logger logger(String getClassName) {
        logger = LogManager.getLogger(getClassName);
         return logger;
    }
}
