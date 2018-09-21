package com.common;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Log {

/*    public static Logger logger = LogManager.getLogger(ProductResController.class);*/
private static final Logger logger =LoggerFactory.getLogger(Log.class);
    //    加载slf4j日志文件
    static {
        BasicConfigurator.configure();
    }
    public static void main(String[] args) {

        logger.info("Current Time: {}", System.currentTimeMillis());
        logger.info("Current Time: " + System.currentTimeMillis());
        logger.info("Current Time: {}", System.currentTimeMillis());
        logger.trace("trace log");
        logger.warn("warn log");
        logger.debug("debug log");
        logger.info("info log");
        logger.error("error log");
    }
    public  static void showLog(String s){
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
        logger.info("Current Time: " + dateFormat.format(System.currentTimeMillis()));
        logger.info(s);
    }
}
