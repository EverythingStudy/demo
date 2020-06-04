package com.example.demo.test.base.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description Hook钩子线程
 * //TODO 应用程序中可以注入多个钩子线程，这样在程序即将退出的时候，也就是JVM即将退出的时候，Hook线程将会被启动执行。
 * //TODO 应用场景：
 * @Date 2020/5/12 18:05
 * @Author cly
 **/
public class HookThread {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("Hook线程");
        }));
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("JVM退出");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public void conversions(){
        int a=15;
        long b=(long)a;
    }
}
