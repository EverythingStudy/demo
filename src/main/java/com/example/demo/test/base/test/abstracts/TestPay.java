package com.example.demo.test.base.test.abstracts;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.base.test.abstracts
 * @ClassName: TestPay
 * @Description
 * @Date 2020/10/16 16:52
 * @Author cly
 **/
public class TestPay {
    public static void main(String[] args) {
        LastPay lastPay=new LastPay();
        lastPay.setPay(new Alipay());
        lastPay.test(100);
    }
}
