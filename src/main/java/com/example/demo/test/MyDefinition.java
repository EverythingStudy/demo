package com.example.demo.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description //TODO 在启动容器时可以添加自己的业务逻辑,如果启动的时候有多个ApplicationRunner和CommandLineRunner，
 *  //TODO 想控制它们的启动顺序，可以实现 org.springframework.core.Ordered接口或者使用 org.springframework.core.annotation.Order注解
 * @Date 2020/9/23 11:42
 * @Author cly
 **/
@Component
@Order(value = 2)
public class MyDefinition implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("启动服务时默认启动");
    }
}
