package com.example.demo.test.collections.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * @Description 集合类中的队列
 * @Date 2019/10/16 14:52
 * @Author cly
 **/
public class TestQueue {
    //1.数组结构得双端队列
    /**
     * @Author cly
     * @Description
     * //TODO 为了提高效率，ArrayDeque采用了循环数组的设计，也就是说虽然基础容器是一个普通的数组（默认容量16），
     * //TODO 但是在逻辑上，这个数组没有固定的开头或结尾，既可以直接向尾部添加数据，也可以直接向头部之前添加数据，不需要大面积地移动数据
     * @Date 15:48 2020/4/21
     * @Param []
     * @return void
     **/
    public void testArrayDeque() {
        Queue queue = new ArrayDeque();
    }
    //2.数组结构得优先级队列
    /**
     * @Author cly
     * @Description
     * //TODO PriorityQueue 一个基于优先级的无界优先级队列。优先级队列的元素按照其自然顺序进行排序，或者根据构造队列时提供的 Comparator 进行排序，具体取决于所使用的构造方法。该队列不允许使用 null 元素也不允许插入不可比较的对象(没有实现Comparable接口的对象)。
     * //TODO PriorityQueue 队列的头指排序规则最小那哥元素。如果多个元素都是最小值则随机选一个。
     * //TODO PriorityQueue 是一个无界队列，但是初始的容量(实际是一个Object[])，随着不断向优先级队列添加元素，其容量会自动扩容，无需指定容量增加策略的细节。
     * @Date 15:45 2020/4/21
     * @Param []
     * @return void
     **/
    public void testPriorityQueue() {
        Queue queue = new PriorityQueue();
        queue.add(new Object());
    }

    public void testLinkedList() {
        Queue queue = new LinkedList();
    }

    public void testLinkBlockingQueue() {
        BlockingQueue blockingQueue = new LinkedBlockingQueue();
        //非阻塞队列dc
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        //阻塞队列
        BlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(12);
        BlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
    }
}
