package com.example.demo.test.design.adapter;

/**
 * @Description 220伏适配器
 * @Date 2020/3/27 15:11
 * @Author cly
 **/
public class Chinese220Adapter implements Adapter{
    @Override
    public boolean support(int vo) {
        return vo==220;
    }
    @Override
    public int outVoltage5V(int vo) {
        return vo/44;
    }
}
