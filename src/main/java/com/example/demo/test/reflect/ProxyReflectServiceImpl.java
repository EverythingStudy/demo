package com.example.demo.test.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description 注意：1.InvocatonHandler invoke方法的参数  2.执行Proxy.newProxyInstance 参数
 * @Date 2020/5/19 14:12
 * @Author cly
 **/
public class ProxyReflectServiceImpl implements InvocationHandler {
    Object obj;
    Object bind(Object obj){
        this.obj=obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass());
        System.out.println("welcome");
        method.invoke(obj,args);
        return null;
    }

    public static void main(String[] args) {
        ProxyService proxyService= (ProxyService) new ProxyReflectServiceImpl().bind(new ProxyServiceImpl());
        proxyService.sayHello();
    }
}
