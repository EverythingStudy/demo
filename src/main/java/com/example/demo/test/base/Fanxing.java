package com.example.demo.test.base;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.base
 * @ClassName: fanxing
 * @Description//TODO 编译时泛型擦除、编译时泛型检查、泛型的主要目的就是指定类型，避免类型转化
 * @Date 2020/11/20 15:14
 * @Author cly
 **/
public class Fanxing {

    /**
     * @Author cly
     * @method
     * @Description //TODO 泛型编译时擦除类型，将转化为object.
     * @Date 15:41 2020/11/20
     * @Param
     * @return
     **/
    @Test
    public void fxcachu(){
        ArrayList<String> list1=new ArrayList<>();
        list1.add("abc");
        ArrayList<Integer> list2=new ArrayList<>();
        list2.add(1);
        //1.编译时泛型擦除转化为object  结果为true
        System.out.println(list1.getClass()==list2.getClass());
        //2.虽然编译时泛型擦除类型都会转化为基类Object。但是在编译时也会进行类型检查，所以定义了泛型类型的对象不可以添加非定义类型的值。
        //list1.add(12);
        //3.虽然不能添加非定义类型的参数，但是可以添加定义类型的子类型参数。
        ArrayList<Number> list3=new ArrayList<>();
        list3.add(1);
        list3.add(1.1);
    }



    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        arrayList.add(1);
        //通过反射可以
        arrayList.getClass().getMethod("add",Object.class).invoke(arrayList,"adf");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

    }
}
