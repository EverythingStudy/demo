package com.example.demo.test.base.arithmetic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.base.arithmetic
 * @ClassName: test
 * @Description
 * @Date 2020/11/18 19:22
 * @Author cly
 **/
public class test {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger sum = new AtomicInteger();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int cur = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = cur * 100 + 1; j <= cur * 100 + 100; j++) {
                        sum.addAndGet(j);
                    }
                }
            });
            thread.start();
            threadList.add(thread);
        }
        for (Thread thread : threadList) {
            thread.join();
        }
        System.out.println(sum.get());
    }
    @Test
    public void mp(){
        int[] a={1,6,89,54,12,78};
        int n=a.length;
        for(int i=n-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(a[i]<a[j]){
                    int x=a[j];
                    a[j]=a[i];
                    a[i]=x;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public int fu(int a){
        if(a==0||a==1){
            return a;
        }else{
            return fu(a-1)+fu(a-2);
        }
    }
    @Test
    public void test(){
        System.out.println(fu(20));
        List list=new ArrayList();
        list.toArray();
    }



        Integer[] a=new Integer[5];
        Integer[] b=new Integer[5];


}
