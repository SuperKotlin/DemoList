package com.test.javademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainActivity {
    private static final Logger logger = LoggerFactory.getLogger("zwx848301");

    public static void main(String[] args) {
        System.err.println("main函数");

        logger.info("111Logger main函数");
        logger.error("{}{}", "222Logger main函数", "---");
    }

}
