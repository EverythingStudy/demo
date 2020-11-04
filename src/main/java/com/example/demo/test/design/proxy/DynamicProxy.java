package com.example.demo.test.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description 代理类
 * @Date 2020/2/28 16:51
 * @Author cly
 **/
public class DynamicProxy implements InvocationHandler {
    Object target;
    DynamicProxy(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行前输出");
        method.invoke(target,args);
        System.out.println("执行后输出");
        return null;
    }
}
