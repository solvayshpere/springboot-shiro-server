package com.solvay.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.solvay.shiro.dao")
@EnableTransactionManagement
public class SpringbootShiroThymleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShiroThymleafApplication.class, args);
    }

}
