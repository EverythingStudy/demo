package com.example.demo.test.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO 内存占位符对象，一个OOMObject大约占64KB
 * TODO 利用jvisualvm查看GC情况
 * @Date 2020/5/9 18:05
 * @Author cly
 **/
public class OOMObject {

    public static void fillHeap(int num) throws InterruptedException {
        List<OOmobject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
           //稍作延时，令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOmobject());
        }

    }
    static class OOmobject{
        public byte[] placeholder = new byte[64 * 1024];
    }
    public static void main(String[] args) throws Exception {
        Thread.sleep(5000);
        System.out.println("开始了");
        fillHeap(1000);
        System.gc();
    }
}
