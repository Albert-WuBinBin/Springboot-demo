package com.wbb.swagger2oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.wbb.swagger2oauth2.mapper")
public class Swagger2Oauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(Swagger2Oauth2Application.class, args);
    }

}


