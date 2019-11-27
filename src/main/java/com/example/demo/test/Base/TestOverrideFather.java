package com.example.demo.test.Base;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 重载1.参数个数或参数类型的顺序必须不同 2.访问权限和返回参数类型不能证明方法重载
 * @Date 2019/10/11 9:51
 * @Author cly
 **/
public class TestOverrideFather {
    public TestOverrideFather(){}
    public Object fartherMethod(String name){
      return "";
  }

     Object fartherMethod(){
        System.out.println("father");
          return "father";
    }

    public Object fartherMethod(int name){
        return "father2";
    }

}
