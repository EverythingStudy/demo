package com.example.demo.test.base.sync;

import org.junit.Test;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.base.sync
 * @ClassName: SyncStaticEnge
 * @Description
 * @Date 2020/10/13 14:50
 * @Author cly
 **/
public class SyncStaticEnge extends SyncStatic {
    @Test
    public void dosoomethingEnge(){
        synchronized (SyncStatic.class){
            dosomething();
        }
    }
}
