package com.zhelihenku.dictionary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot方式启动类
 *
 * @author PhilWang
 * @Date 2017/5/21 12:06
 */
@SpringBootApplication
public class DictionaryApplication {

    private final static Logger logger = LoggerFactory.getLogger(DictionaryApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DictionaryApplication.class, args);
        logger.info("DictionaryApplication is success!");
    }
}
