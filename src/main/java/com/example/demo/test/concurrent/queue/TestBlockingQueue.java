package com.example.demo.test.concurrent.queue;


import java.util.concurrent.*;

/**
 * @Description JUC包中阻塞队列--采用lock加锁的方式控制并发
 * @Date 2019/8/27 16:12
 * @Author cly
 **/
public class TestBlockingQueue {


    public static void testArrayBlockingQueue() {
        BlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(2);
        for (; ; ) {
            boolean flag = arrayBlockingQueue.offer(1);
            System.out.println(arrayBlockingQueue.size());
        }

    }

    public void testLinkedBlockingQueue() {
        BlockingQueue linkerBlockingQueue = new LinkedBlockingQueue();
    }

    public void testLinkedBlockingDeque() {
        BlockingQueue linkedBlockingDeque = new LinkedBlockingDeque();
    }

    public void testPriorityBlockingQueue() {
        BlockingQueue linkerBlockingQueue = new PriorityBlockingQueue();
    }

    public void testDelayQueue() {
        BlockingQueue linkerBlockingQueue = new DelayQueue();
    }

    public void testLinkedTransferQueue() {
        BlockingQueue linkerBlockingQueue = new LinkedTransferQueue();
    }

    public void testSynchronousQueue() {
        BlockingQueue linkerBlockingQueue = new SynchronousQueue();
    }
}
