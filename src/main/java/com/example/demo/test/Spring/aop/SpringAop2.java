package com.example.demo.test.Spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description 切面类
 * @Date 2019/11/25 14:44
 * @Author cly
 **/
@Aspect
@Component
public class SpringAop2 {
    @Pointcut("execution(* com.example.demo.test.Spring.aop.ProxyServiceImpl2.*(..))")
    public void service(){}

    @Before("service()")
    public void get(){
        System.out.println("springAop2===age");
    }
}
