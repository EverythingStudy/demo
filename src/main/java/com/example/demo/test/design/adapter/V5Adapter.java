package com.example.demo.test.design.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 更像是策略模式
 * @Date 2020/3/27 17:27
 * @Author cly
 **/
public class V5Adapter {
    //不同的适配器装载
    List<Adapter> list=new ArrayList<>();
    V5Adapter(){
        this.list.add(new Chinese220Adapter());
        this.list.add(new Janpan110Adapter());
    }
    public int outVoltage(Voltage voltage) {
        for (Adapter adapter:list){
            if(adapter.support(voltage.outVoltage())){
                return adapter.outVoltage5V(voltage.outVoltage());
            }
        }
        return 0;
    }
}
