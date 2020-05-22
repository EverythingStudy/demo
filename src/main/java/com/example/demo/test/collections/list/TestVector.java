package com.example.demo.test.collections.list;

import java.util.Vector;

/**
 * vector同list数据结构相同，唯一不同是方法都是同步的synchronized修饰
 *
 */
public class TestVector {

    public void test(){
        Vector vector=new Vector();
        vector.add(new Object());
        vector.remove(new Object());
    }

    private static Vector<Integer> vector=new Vector<>();

    public static void main(String[] args) {
        while (true){
            for(int i=0;i<10;i++){
                vector.add(i);
            }
            Thread threadRemove=new Thread(()->{
                for(int i=0;i<10;i++){
                    vector.remove(i);
                }
            });
            Thread threadPrint=new Thread(()->{
                for(int i=0;i<10;i++){
                    System.out.println(vector.get(i));
                }
            });
            threadRemove.start();
            threadPrint.start();
            //while(Thread.activeCount()>20);
        }
    }
}
