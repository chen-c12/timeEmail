package com.chenddd.timeemail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //这个注解代表开启对定时任务的支持，重要
public class TimeEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeEmailApplication.class, args);
    }

}
