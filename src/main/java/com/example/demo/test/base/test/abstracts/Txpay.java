package com.example.demo.test.base.test.abstracts;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.base.test.abstracts
 * @ClassName: Txpay
 * @Description
 * @Date 2020/10/16 16:41
 * @Author cly
 **/
public class Txpay extends Pay {
    @Override
    public void pay(int k) {
        System.out.println("txpay");
    }
    public String getName(){
        return "Txpay";
    }
}
