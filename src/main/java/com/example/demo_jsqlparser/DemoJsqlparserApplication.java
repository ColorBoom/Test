package com.example.demo_jsqlparser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo_jsqlparser.mapper")
public class DemoJsqlparserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJsqlparserApplication.class, args);
    }
}
