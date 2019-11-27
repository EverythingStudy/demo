package com.example.demo.test.Spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * @Description 切面类
 * @Date 2019/11/25 10:20
 * @Author cly
 **/
@Aspect
@Component
public class SpringAop {
    /*
     * @Author cly
     * @Description //TODO 定义切点
     * @Date 17:17 2019/11/26
     * @Param 
     * @return 
     **/
    
    @Pointcut("execution(* com.example.demo.test.Spring.aop.ProxyServiceImpl.*(..))")
    public void pointCutService(){}
    /*
     * @Author cly
     * @Description //TODO 通知方法
     * @Date 17:17 2019/11/26
     * @Param 
     * @return 
     **/
    
    @Before("pointCutService()")
    public void before() {
        System.out.println("前置通知!");
    }

    @After("pointCutService()")
    public void after(){
        System.out.println("后置通知!如果切点方法执行出现异常仍然执行.");
    }
    /*
     * @Author cly
     * @Description //TODO 环绕通知
     * @Date 17:18 2019/11/26
     * @Param 
     * @return 
     **/
    
    @Around("pointCutService()")
    public void around(ProceedingJoinPoint pjp){
        System.out.println("环绕通知!-前面部分");
        // 执行切点(业务)方法
        try {
            Object result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕通知!-后面部分");
    }
    /*
     * @Author cly
     * @Description //TODO 后置通知
     * @Date 17:18 2019/11/26
     * @Param 
     * @return 
     **/
    
    @After("pointCutService()")
    public void afterReturning() {
        System.out.println("后置通知!如果切点方法执行出现异常就不执行.");
    }
    /*
     * @Author cly
     * @Description //TODO 异常通知
     * @Date 17:21 2019/11/26
     * @Param 
     * @return 
     **/
    
    @AfterThrowing("pointCutService()")
    public void afterThrowing() {
        System.out.println("异常通知!");
    }
}
