package com.example.demo.test.design.adapter;

/**
 * @Description
 * @Date 2020/3/27 17:48
 * @Author cly
 **/
public class Janpan110Adapter implements Adapter {
    @Override
    public boolean support(int vo) {
        return vo==110;
    }

    @Override
    public int outVoltage5V(int vo) {
        return vo/22;
    }
}
