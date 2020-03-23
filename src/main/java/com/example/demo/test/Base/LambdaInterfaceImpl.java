package com.example.demo.test.Base;

import org.junit.Test;

/**
 * @Description 自定义Lambada方法
 * @Date 2020/3/18 9:06
 * @Author cly
 **/
public class LambdaInterfaceImpl{
    public String getLambdaInterface(LambdaInterface lambdaInterface){
        System.out.println(lambdaInterface.defaultTest());
        System.out.println(LambdaInterface.staticTest());
        String s="1=="+lambdaInterface.abstractTest();
        return  s;
    }
    @Test
    public void test(){
        LambdaInterfaceImpl lambdaInterface=new LambdaInterfaceImpl();
        String s=lambdaInterface.getLambdaInterface(()->{
            return "lambdaInterface";
        });
        System.out.println(s);
    }
}
