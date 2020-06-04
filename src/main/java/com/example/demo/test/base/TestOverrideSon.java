package com.example.demo.test.base;

/**
 * @Description 子类重写父类方法：1.方法名、参数必须相同 2.访问类型不要大于父类 3.返回参数可以是父类返回参数的子类
 * @Date 2019/11/24 15:12
 * @Author cly
 **/
public class TestOverrideSon extends TestOverrideFather {
    @Override
    public String fartherMethod(){
        System.out.println("son");
       return "son";
    }

    public static void main(String[] args) {
        TestOverrideSon testSetSon=new TestOverrideSon();
        testSetSon.fartherMethod();
    }
}
