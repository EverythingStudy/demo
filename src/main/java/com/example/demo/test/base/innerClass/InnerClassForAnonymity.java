package com.example.demo.test.Base.innerClass;

/**
 * 首先我们应该知道匿名内部类匿名是因为匿名内部类的具体名字不会被我们在程序当众编写出来，因为它已经在主方法当中被实例化了。
 * 匿名内部类的使用：匿名内部类实现类型为：抽象类和接口，
 */
public class InnerClassForAnonymity {

    public void test() {

        Chouxiang c = new Chouxiang() {
            String name = "Geek Song too";

            public void say3() {
                System.out.println("这是匿名内部类当中的方法，重写了抽象类的方法");
                System.out.println(name);
            }
        };
        c.say3();
        Jiekou yui = new Jiekou() {
            @Override
            public void say5() {
                System.out.println("这是继承的接口当中的方法");
            }
        };
        yui.say5();
    }
}
