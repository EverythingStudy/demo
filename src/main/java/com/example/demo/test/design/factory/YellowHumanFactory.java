package com.example.demo.test.design.factory;

/**
 * @Description
 * @Date 2020/2/13 14:05
 * @Author cly
 **/
public class YellowHumanFactory extends HumanFactory {

    @Override
    public Human getHuman() {
        return new YellowHuman();
    }
}
