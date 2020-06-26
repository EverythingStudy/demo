package com.example.demo.test.jvm;

/**
 * @Description
 * @Date 2020/5/8 18:17
 * @Author cly
 **/
public class Test {
    private static final int _1MB=1024*1024;
    @org.junit.Test
    public void test(){

    }

    public static void main(String[] args) {
        byte[]allocation1,allocation2,allocation3;
        allocation1=new byte[_1MB/4];
        //什么时候进入老年代取决于XX：MaxTenuringThreshold设置
        allocation2=new byte[4*_1MB];
        allocation3=new byte[4*_1MB];
        allocation3=null;
        allocation3=new byte[4*_1MB];
        System.out.println("test");
    }
}
