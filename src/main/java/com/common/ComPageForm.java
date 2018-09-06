package com.common;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
/*
* @autor cai sheng tang
* 作用开启 mybatis 分页插件
* */
@Configuration
public class ComPageForm {
    @Bean
     public PageHelper pageHelper(){
               PageHelper pageHelper = new PageHelper();
               Properties properties = new Properties();
               properties.setProperty("offsetAsPageNum","true");
               properties.setProperty("rowBoundsWithCount","true");
               properties.setProperty("reasonable","true");
               properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
                pageHelper.setProperties(properties);
                return pageHelper;
            }
}
