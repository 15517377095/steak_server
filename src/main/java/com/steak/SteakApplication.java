package com.steak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.steak.dao")
public class SteakApplication {

    public static void main(String[] args) {
        SpringApplication.run(SteakApplication.class, args);
    }

}
