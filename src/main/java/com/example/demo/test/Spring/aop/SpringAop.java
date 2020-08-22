package com.example.demo.test.Spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * @Description 切面类 1.利用@Aspect注解配置切面  @Pointcut 配置切点位置
 *  2.切点位置配置规则 切点表达式
 *             execution(表达式)
 *             public void com.huawei.service.UserServiceImpl.save()
 *             void com.huawei.service.UserServiceImpl.save() 默认就是public
 *             * com.huawei.service.UserServiceImpl.save() 返回值任意
 *             * com.huawei.service.*ServiceImpl.save() 指定包中所有ServiceImpl结尾的类
 *             * com.huawei.service.*ServiceImpl.*() 方法名任意
 *             * com.huawei.service.*ServiceImpl.*(..) 参数列表任意
 *             * com.huawei.service..*ServiceImpl.*(..) 当前包以及后代包
 * @Date 2019/11/25 10:20
 * @Author cly
 **/
@Aspect
@Component
public class SpringAop {
    /*
     * @Author cly
     * @Description //TODO 定义切点，根据要操作的方法范围，可以配置多个切点
     * @Date 17:17 2019/11/26
     * @Param 
     * @return 
     **/
    
    @Pointcut("execution(* com.example.demo.test.Spring.aop.ProxyServiceImpl.getName())")
    public void pointCutService(){}
    @Pointcut("execution(* com.example.demo.test.Spring.aop.ProxyServiceImpl.getAge())")
    public void pointCutServiceSet(){}
    @Pointcut(value="execution(* com.example.demo.test.Spring.aop.TestController.getAges())")
    public void pointCutController(){}
    /*
     * @Author cly
     * @Description //TODO 通知方法
     * @Date 17:17 2019/11/26
     * @Param 
     * @return 
     **/
    
    @Before("pointCutController()")
    public void before() {
        System.out.println("前置通知!");
    }

    @After("pointCutServiceSet()")
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
    
    @AfterReturning(value = "pointCutService()",returning="name")
    public void afterReturning(String name) {
        System.out.println("后置通知!如果切点方法执行出现异常就不执行.");
        System.out.println("返回值=="+name);
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
