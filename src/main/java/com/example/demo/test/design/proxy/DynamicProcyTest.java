package com.example.demo.test.design.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @Description 测试动态代理类
 * @Date 2020/2/28 16:54
 * @Author cly
 **/
public class DynamicProcyTest {

    @Test
    public void proxy(){
        TargetInterface targetInterface=new TargetInterfaceImpl();
        TargetInterface targetInterface1= (TargetInterface) Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(),targetInterface.getClass().getInterfaces(),new DynamicProxy(targetInterface));
        targetInterface1.targetMehod();
    }
}
