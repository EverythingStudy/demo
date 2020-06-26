package com.example.demo.test.jvm;

/**
 * @Description TODO 双亲委派模型-->系统类加载器-->扩展类加载器-->启动类加载器
 * TODO 类加载器加载流程--java.lang.ClassLoader.java-->loadClass(String name)方法
 * @Date 2020/5/14 17:29
 * @Author cly
 **/
public class LoadClassTest {

    public static void main(String[] args) {
        //应用程序加载器
        System.out.println(LoadClassTest.class.getClassLoader());
        //扩展类加载器
        System.out.println(LoadClassTest.class.getClassLoader().getParent());
        //默认为null--通过本地方法调用启动类加载器
        System.out.println(LoadClassTest.class.getClassLoader().getParent().getParent());
    }
}
