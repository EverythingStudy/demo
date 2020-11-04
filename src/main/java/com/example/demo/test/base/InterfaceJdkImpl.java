package com.example.demo.test.base;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description 接口中可以存在用default修饰的方法,可以作为所有实现类的公共方法使用。
 * @Date 2020/3/17 17:54
 * @Author cly
 **/
public class InterfaceJdkImpl implements InterfaceJdk {
    Logger logger= LoggerFactory.getLogger(InterfaceJdkImpl.class);

    @Test
    public void testForInterface(){
        InterfaceJdk interfaceJdk=new InterfaceJdkImpl();
        logger.info(interfaceJdk.test());
    }
}
