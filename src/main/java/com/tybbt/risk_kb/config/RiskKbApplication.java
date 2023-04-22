package com.tybbt.risk_kb.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.tybbt")
@SpringBootApplication
@MapperScan("com.tybbt.risk_kb.mapper")
public class RiskKbApplication {

    public static void main(String[] args) {
        SpringApplication.run(RiskKbApplication.class, args);
    }

}
