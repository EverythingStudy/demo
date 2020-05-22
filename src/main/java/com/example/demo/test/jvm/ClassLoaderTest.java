package com.example.demo.test.jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description TODO z自定义类加载器
 * @Date 2020/5/14 11:39
 * @Author cly
 **/
public class ClassLoaderTest {
    public static void main(String[]args)throws Exception

    {
        ClassLoader myLoader = new ClassLoader(){
        @Override
        public Class<?>loadClass(String name)throws ClassNotFoundException {
            try {
                String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if(is == null){
                    return super.loadClass(name);
                }
                byte[] b = new byte[is.available()];
                is.read(b);
                return defineClass(name, b,0,b.length);
            } catch(IOException e){
                throw new ClassNotFoundException(name);
            }
        }
    };
        Object obj = myLoader.loadClass("com.example.demo.test.jvm.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        //false--实例类型是否相同前提是同一个类加载器加载的情况
        System.out.println(obj instanceof com.example.demo.test.jvm.ClassLoaderTest);
    }
}
