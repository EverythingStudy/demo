package com.example.demo.test.concurrent.Thread;

import com.example.demo.test.base.bean.Album;
import org.junit.Test;
import org.springframework.format.datetime.DateFormatter;

import java.util.Date;
import java.util.Locale;

/**
 * @Description TODO ThreadLoacl 解决
 * @Date 2019/8/21 12:14
 **/
public class TestThreadLocal {
    ThreadLocal<Integer> t = new ThreadLocal<>();
    @Test
    public void testFor() {
        test();
    }

    public void test() {
        new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                t.set(15);
                System.out.println(Thread.currentThread().getName() + "==" + t.get());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "==" + t.get());
            }
        }.start();
    }



    @Test
    public void testThread() {
        ThreadLocal threadLocal = ThreadLocal.withInitial(() -> new ThreadLocal());
        threadLocal.set("test");
        System.out.println(threadLocal.get());

        ThreadLocal<DateFormatter> dateFormatter = ThreadLocal.withInitial(() -> new DateFormatter());
        System.out.println(dateFormatter.get().print(new Date(), Locale.CHINA));
        //System.out.println(dateFormatter.get().print(new Date(),new Locale(LISO_PATTERNS.)));
    }
}
