package com.example.demo.test.base.test.abstracts;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.base.test.abstracts
 * @ClassName: TestPay
 * @Description
 * @Date 2020/10/16 16:41
 * @Author cly
 **/
public class LastPay {
  private Pay pay;
  public void setPay(Pay pay){
      this.pay=pay;
  }
  public void test(int k){
      pay.pay(k);
  }
}
