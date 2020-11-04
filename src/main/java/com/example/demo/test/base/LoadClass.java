package com.example.demo.test.base;

import com.example.demo.test.base.bean.Album;

import java.net.URLClassLoader;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.base
 * @ClassName: LoadClass
 * @Description
 * @Date 2020/10/27 18:32
 * @Author cly
 **/
public class LoadClass {
    public static void main(String[] args) {
        try {
            Album.class.getClassLoader().loadClass("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
