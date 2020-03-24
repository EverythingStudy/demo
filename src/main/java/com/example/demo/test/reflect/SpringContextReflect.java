package com.example.demo.test.reflect;

import com.sun.org.apache.bcel.internal.util.ClassLoader;
import org.junit.Test;

/**
 * @Description
 * @Date 2020/2/25 16:46
 * @Author cly
 **/
public class SpringContextReflect {
    @Test
    public void reflect(){
        Class springContext= null;
        try {
            springContext = SpringContext.class.getClassLoader().loadClass("com.example.demo.test.reflect.SpringContext");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            SpringContext bean= (SpringContext)springContext.newInstance();
            System.out.println(bean.getBean());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
