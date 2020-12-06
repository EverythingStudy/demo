package com.example.demo.test.base.classload;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.base.classload
 * @ClassName: LoadClass
 * @Description
 * @Date 2020/11/20 10:14
 * @Author cly
 **/
public class LoadClass {
    public static void main(String[] args) {
        try {
            Class classs=Class.forName("com.example.demo.test.base.bean.Track");
            Constructor constructor=classs.getConstructor(String.class,Integer.class);
            Object object=constructor.newInstance("liming",15);
            //获取私有属性
            Field field=classs.getDeclaredField("length");
            //设置可访问
            field.setAccessible(true);
            System.out.println(field.get(object));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }  catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
