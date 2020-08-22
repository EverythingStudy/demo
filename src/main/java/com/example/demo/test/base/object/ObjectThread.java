package com.example.demo.test.base.object;

/**
 * @Description 打印hello world 开启几个线程
 * @Date 2020/8/18 15:03
 * @Author cly
 **/
public class ObjectThread {
    public static void main(String[] args) {
        System.out.println("hello world");
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;
        while (group != null) {
            topGroup = group;
            group = group.getParent();
        }
        int nowThreads = topGroup.activeCount();
        Thread[] lstThreads = new Thread[nowThreads];
        topGroup.enumerate(lstThreads);
        for (int i = 0; i < nowThreads; i++) {
            System.out.println("线程number：" + i + " = " + lstThreads[i].getName());
        }
    }
}
