package com.example.demo.test.design.adapter;

/**
 * @Description
 * @Date 2020/3/27 17:35
 * @Author cly
 **/
public class Test {
    public static void main(String[] args) {
        V5Adapter v5Adapter=new V5Adapter();
        Voltage voltage=new VoltageImpl(220);
        System.out.println(v5Adapter.outVoltage(voltage));
    }
}
