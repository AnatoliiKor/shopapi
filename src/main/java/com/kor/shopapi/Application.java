package com.kor.shopapi;

import com.kor.shopapi.services.MyLogs;
import org.apache.logging.log4j.Level;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        MyLogs.logger.trace("Trace");
        MyLogs.logger.debug("debug");
        MyLogs.logger.info("info");
        MyLogs.logger.warn("warn");
        MyLogs.logger.error("error");

        Level[] levels = Level.values();
        MyLogs.logger.getName();
    }
}