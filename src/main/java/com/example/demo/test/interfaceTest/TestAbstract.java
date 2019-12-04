package com.example.demo.test.interfaceTest;

/**
 * @Description 抽象类
 * 1.抽象方法只能在抽象类中
 * 2.抽象方法只有定义没有实现，可以子类重写实现.
 * 3.抽象类里面可以同时存在抽象方法和普通股方法
 * 4.类和方法都必须用abstract修饰
 * @Date 2019/12/4 17:56
 * @Author cly
 **/
public abstract  class TestAbstract {
    public abstract void getNme();
    public void getPrice(){
        System.out.println("123元");
        getNme();
    }
}
