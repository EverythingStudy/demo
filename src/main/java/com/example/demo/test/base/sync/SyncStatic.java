package com.example.demo.test.base.sync;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.base.sync
 * @ClassName: SyncStatic
 * @Description
 * @Date 2020/10/13 14:48
 * @Author cly
 **/
public class SyncStatic {
    public void dosomething(){
        synchronized (getClass()){
            System.out.println("SyncStatic");
        }
    }
}
