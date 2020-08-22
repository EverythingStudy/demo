package com.example.demo.test.design.adapter;

/**
 * @Description 110伏电压
 * @Date 2020/3/27 14:40
 * @Author cly
 **/
public class VoltageImpl implements Voltage{
    private int vo;
    VoltageImpl(int vo){
        this.vo=vo;
    }
    @Override
    public int outVoltage() {
        return this.vo;
    }
}
