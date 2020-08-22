package com.example.demo.test.commons.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;

/**
 * @Description 池对象工厂
 * @Date 2020/7/10 18:33
 * @Author cly
 **/
public class PoolObjectFactory extends BasePooledObjectFactory<Cont> {

    @Override
    public Cont create() throws Exception {
        return null;
    }

    @Override
    public PooledObject<Cont> wrap(Cont cont) {
        return null;
    }
}
