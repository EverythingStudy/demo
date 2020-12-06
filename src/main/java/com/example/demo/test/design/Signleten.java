package com.example.demo.test.design;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description 双重检验机制定义懒汉单例，
 * 创建单例：1.私有的构造方法 2.私有的volatile修饰的实例对象 3.公有的获取实例方法
 * @Date 2020/2/12 17:36
 * @Author cly
 **/
public class Signleten {

    private Signleten(){}
    private volatile static Signleten signleten=null;
    public static Signleten getSignleten(){
        if(signleten==null){
            synchronized(Signleten.class){
                if(signleten==null){
                    signleten=new Signleten();
                }
            }
        }
        return signleten;
    }

    public static void main(String[] args) {
        //利用反射打破单例 创建多个对象
        try {
            //获得构造器
            Constructor <Signleten> constructor=Signleten.class.getDeclaredConstructor();
            //设置为可访问
            constructor.setAccessible(true);
            //实例化对象
            Signleten signleten=constructor.newInstance();
            Signleten signleten2=constructor.newInstance();
            System.out.println(signleten.equals(signleten2));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    /**
     * @Author cly
     * @Description //TODO 枚举的方式实现单例
     * @Date 11:05 2020/2/13
     * @Param 
     * @return 
     **/
    enum SingletenEnum {
        INSTANCE;
        private Connection connection=null;
        private  SingletenEnum(){
            connection=new Connection();
        }
        public Connection getConnection(){
            return connection;
        }
    }
/**
 * @Author cly
 * @Description //另一种单例
 * @Date 11:11 2020/2/13
 * @Param
 * @return
 **/

 static class Singleten{
        private  static final  Connection connection=new Connection();
        private Singleten(){}
        public Connection getConnection(){return connection;}
 }

}
