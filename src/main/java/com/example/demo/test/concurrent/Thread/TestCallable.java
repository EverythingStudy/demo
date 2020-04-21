package com.example.demo.test.concurrent.Thread;

import java.util.concurrent.*;

/**
 * @Description
 * @Date 2019/8/21 14:02
 **/
public class TestCallable {

    BlockingQueue QRqueue=new LinkedBlockingQueue();
    ExecutorService QrexecutorService=new ThreadPoolExecutor(2,10,0L,TimeUnit.SECONDS,QRqueue);

    public boolean  C_move(String studyinstanceuid){
        Future<Boolean> flag= QrexecutorService.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() {
                try {
                    return true;
                } catch (Exception e) {
                    System.err.println("movescu: " + e.getMessage());
                    e.printStackTrace();
                }
                return false;
            }
        });
        flag.cancel(true);
        try {
            return flag.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }
    static  class CallableData implements  Callable<String>{
        @Override
        public String call() throws Exception {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(5%6);
//        TestCallable.CallableData C=  new TestCallable.CallableData();
//        FutureTask futureTask=new FutureTask(C);
//        futureTask.cancel(true);
//        Thread thread=new Thread(futureTask);
//        thread.start();
//        TestCallable testCallable=new TestCallable();
//        System.out.println(testCallable.C_move("s"));
    }
}
