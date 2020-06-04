package com.example.demo.test.base.lambda;

/**
 * @Description
 * @Date 2020/3/18 10:37
 * @Author cly
 **/
@FunctionalInterface
public interface LambdaInterface {
     String abstractTest();
    default String defaultTest(){return "接口中的default方法";}
    static String staticTest(){return "接口中的static方法";}
}
