package com.example.demo.test.concurrent;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description
 * @Date 2020/4/21 16:39
 * @Author cly
 **/
public class TestCyclicBarrier {


//    @JunitTest
//    public void test() {
//        for(int i=0;i<10;i++){
//            new Thread(()->{new ThreadTest(cyclicBarrier);});
//            //threadTest.start();
//        }
//    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(8);
        for(int i=0;i<10;i++){
            new Thread(()->{
                System.out.println("await");
                try {
                    cyclicBarrier.await();
                    System.out.println("reset");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }}).start();
        }
    }
}
