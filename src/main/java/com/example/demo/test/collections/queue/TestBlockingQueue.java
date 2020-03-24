package com.example.demo.test.collections.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description
 * @Date 2019/8/27 16:12
 * @Author cly
 **/
public class TestBlockingQueue {

BlockingQueue linkerBlockingQueue=new LinkedBlockingQueue();

    public static void main(String[] args) {
        BlockingQueue blockingQueue=new ArrayBlockingQueue(2);
        for(;;){
//            try {
                boolean flag=blockingQueue.offer(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(blockingQueue.size());
        }
//        BlockingQueue blockingQueue=new PriorityBlockingQueue();
//        ((PriorityBlockingQueue) blockingQueue).comparator();
//        String date="";
//        date.compareTo("11");
    }
}
