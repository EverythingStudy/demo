package com.example.demo.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Date 2020/9/23 13:13
 * @Author cly
 **/
@Component
//@Order(value = 3)
public class MyDefinitonTwo implements CommandLineRunner, Ordered {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("启动服务器启动二");
    }

    @Override
    public int getOrder() {
        return 4;
    }
}
