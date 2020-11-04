package com.example.demo.test.base.test.abstracts;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.base.test.abstracts
 * @ClassName: Alipay
 * @Description
 * @Date 2020/10/16 16:40
 * @Author cly
 **/
public class Alipay extends Pay {
    @Override
    public void pay(int k) {
        System.out.println("alipay");
    }
    public String getName(){
        return "Alipay";
    }
}
