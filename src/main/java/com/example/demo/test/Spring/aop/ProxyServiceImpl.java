package com.example.demo.test.Spring.aop;

import org.springframework.stereotype.Service;

/**
 * @Description 实现代理对象接口类
 * @Date 2019/11/25 10:22
 * @Author cly
 **/
@Service(value = "aop1")
public class ProxyServiceImpl implements ProxyService {
    @Override
    public String getName() {
        System.out.println("获取name接口");
        return "王文娜";
    }

    @Override
    public void getAge() {
        System.out.println("获取age接口");
    }
}
