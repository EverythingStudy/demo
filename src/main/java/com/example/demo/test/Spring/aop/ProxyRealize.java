package com.example.demo.test.Spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description 动态代理代理类
 * @Date 2019/11/25 10:26
 * @Author cly
 **/
public class ProxyRealize implements InvocationHandler {
    private ProxyService target;
    public ProxyService getObject(ProxyService object){
        this.target=object;
        return (ProxyService) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{ProxyService.class},this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前打印");
        method.invoke(target,args);
        System.out.println("代理后打印");
        return null;
    }

    public static void main(String[] args) {
        ProxyRealize proxyRealize=new ProxyRealize();
        ProxyService proxyServices=proxyRealize.getObject(new ProxyServiceImpl());
        proxyServices.getName();
    }
}
