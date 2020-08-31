package com.example.demo.test.concurrent.Thread;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description FurtureTask 获取线程结果get() 取消cacele()
 * @Date 2019/9/26 15:46
 * @Author cly
 **/
public class TestFutureTask {
    public static void main(String[] args) {
        TestFutureTask testFutureTask = new TestFutureTask();
        testFutureTask.test();
    }

    ExecutorService executorService = new ThreadPoolExecutor(2, 10, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));

    /**
     * @return void
     * @Author cly
     * @Description //TODO 把futureTask交给executorService执行
     * @Date 15:55 2020/2/7
     * @Param []
     **/
    public void test() {
        AtomicInteger k = new AtomicInteger(0);
        for (; ; ) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    CallTest<String> callTest = new CallTest<>(k.get());
                    FutureTask<String> future = (FutureTask<String>) executorService.submit(callTest);
                    try {
                        if (future.isDone()) {
                            // future.cancel(true);//取消
                            System.out.println("获取get");
                            System.out.println(future.get());//获取结果
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                }
            }, "dd");
            thread.start();
            k.addAndGet(1);
            if (k.get() == 10) {
                executorService.isShutdown();
                break;
            }
        }

    }

    class CallTest<String> implements Callable<String> {
        private int s = 0;

        CallTest(int k) {
            this.s = k;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            return (String) Integer.toString(s);
        }
    }

    /**
     * @return void
     * @Author cly
     * @Description //TODO futureTask单独执行
     * @Date 16:49 2020/2/7
     * @Param []
     **/
    @Test
    public void testExecutor() {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new CallTest<>(2));
        futureTask.run();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
