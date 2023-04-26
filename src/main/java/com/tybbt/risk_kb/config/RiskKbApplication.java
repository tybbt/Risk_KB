package com.tybbt.risk_kb.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@ComponentScan("com.tybbt")
@SpringBootApplication
@MapperScan("com.tybbt.risk_kb.mapper")
public class RiskKbApplication {
    private static final Logger LOG = LoggerFactory.getLogger(RiskKbApplication.class);
    public static void main(String[] args) {
//        SpringApplication.run(RiskKbApplication.class, args);
        SpringApplication app = new SpringApplication(RiskKbApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }

}
