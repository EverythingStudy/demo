package com.example.demo.test.Spring.aop;

import org.springframework.stereotype.Service;

/**
 * @Description 实现代理对象接口类
 * @Date 2019/11/25 14:56
 * @Author cly
 **/
@Service(value = "aop2")
public class ProxyServiceImpl2 implements ProxyService {
    @Override
    public void getName() {
        System.out.println("proxy2");
    }

    @Override
    public void getAge() {
        System.out.println("age");
    }
}
