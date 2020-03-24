package com.example.demo.test.collections.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description Atomic.LOCKS
 * @Date 2019/10/16 14:52
 * @Author cly
 **/
public class TestQueue {
    public void testLinkBlockingQueue(){
        BlockingQueue blockingQueue=new LinkedBlockingQueue();
        //非阻塞队列dc
        ConcurrentLinkedQueue concurrentLinkedQueue=new ConcurrentLinkedQueue();
        //阻塞队列
        BlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(12);
        BlockingQueue linkedBlockingQueue=new LinkedBlockingQueue();
    }
}
