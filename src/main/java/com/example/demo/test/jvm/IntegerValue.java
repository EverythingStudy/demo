package com.example.demo.test.jvm;

/**
 * @Description 测试自动封箱，拆箱
 * @Date 2020/5/19 16:06
 * @Author cly
 **/
public class IntegerValue {
    public static void main(String[]args){
        Integer a=1;
        Integer b=2;
        Integer c=3;
        Integer d=3;
        Integer e=321;
        Integer f=321;
        Long g=3L;
        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(e.equals(f));
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));
    }
}
