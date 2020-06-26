package com.example.demo.test.Base.baseClass;

import org.junit.Test;

/**
 * 理解基础数据类型源码-valueof-equals-IntegerCache
 * 封箱拆箱：装箱就是自动将基本数据类型转换为包装器类型；拆箱就是自动将包装器类型转换为基本数据类型。
 * Integer派别：Integer、Short、Byte、Character、Long这几个类的valueOf方法的实现是类似的。会从缓存池中获取数据
 * Double派别：Double、Float的valueOf方法的实现是类似的。每次都返回不同的对象。
 * valueof同种数据类型的格式转化 涉及到封箱
 * equals 判断时会先判断类型是否相同-值是否相同
 *
 * 1、需要知道什么时候会引发装箱和拆箱
 *
 * 2、装箱操作会创建对象，频繁的装箱操作会消耗许多内存，影响性能，所以可以避免装箱的时候应该尽量避免。
 *
 * 3、equals(Object o) 因为原equals方法中的参数类型是封装类型，所传入的参数类型（a）是原始数据类型，所以会自动对其装箱，反之，会对其进行拆箱
 *
 * 4、当两种不同类型用==比较时，包装器类的需要拆箱， 当同种类型用==比较时，会自动拆箱或者装箱
 */
public class IntegerTest {
    /**
     * @param
     * @Autor cly
     * @Date
     */
    @Test
    public void test() {
        //自动装箱--会将对象放入缓存池
        Integer integer = 200;
        //自动拆箱
        int baseInteger = 200;
        //valueof中会将引用封箱-判断是否大于127小于-128，在这个阈值范围外创建新的对象
        Integer.valueOf(baseInteger);
        System.out.println(integer.equals(baseInteger));//true-自动装箱

        Integer nextInteger = 200;

        System.out.println(integer.equals(nextInteger));//true
        System.out.println(integer == nextInteger);//false
    }

    /**
     * 1、v1和v2会进行自动装箱，执行了valueOf函数，它们的值在(-128,128]这个范围内，它们会拿到SMALL_VALUES数组里面的同一个对象SMALL_VALUES[228]，它们引用到了同一个Integer对象，所以它们肯定是相等的。
     * <p>
     * 2、v3和v4也会进行自动装箱，执行了valueOf函数，它们的值大于128，所以会执行new Integer(200)，也就是说它们会分别创建两个不同的对象，所以它们肯定不等。
     */
    @Test
    public void testTwo() {
        Integer v1 = 100;
        Integer v2 = 100;
        Integer v3 = 200;
        Integer v4 = 200;

        System.out.println(v1 == v2);//true
        System.out.println(v3 == v4);//false
        System.out.println(v1.equals(v2));//true
        System.out.println(v3.equals(v4));//false
    }

    /**
     * double 类型和integer对象不同，因为它在这个范围内个数是无限的,在某个范围内的整型数值的个数是有限的，而浮点数却不是。
     * Double里面的做法很直接，就是直接创建一个对象，所以每次创建的对象都不一样。
     * double.valueof()-->
     * public static Double valueOf(double d) {
     * return new Double(d);
     * }
     */
    @Test
    public void doubleTest() {
        Double i1 = 100.0;
        Double i2 = 100.0;
        Double i3 = 200.0;
        Double i4 = 200.0;

        System.out.println(i1 == i2); //false
        System.out.println(i3 == i4); //false
    }

    /**
     * boolean valueof
     * public static Boolean valueOf(boolean b) {
     * return (b ? TRUE : FALSE);
     * }
     */
    @Test
    public void booleanTest() {
        Boolean i1 = false;
        Boolean i2 = false;
        Boolean i3 = true;
        Boolean i4 = true;

        System.out.println(i1 == i2);//true
        System.out.println(i3 == i4);//true
    }

    @Test
    public void longTest() {
        Integer num1 = 100;
        int num2 = 100;
        Long num3 = 200l;
        System.out.println(num1 + num2);  //200
        System.out.println(num3 == (num1 + num2));  //true
        System.out.println(num3.equals(num1 + num2));  //false 判断类型部位Long
    }
}
