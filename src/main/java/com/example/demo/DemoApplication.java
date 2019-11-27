package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement// 开启注解事务管理，等同于xml配置文件中的 <tx:annotation-driven />
@SpringBootApplication
@MapperScan("com.example.demo.test.Spring.dao")//作用
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
