package com.example.demo.test.design.factory;

/**
 * @Description
 * @Date 2020/2/13 14:06
 * @Author cly
 **/
public class BlockHumanFactory extends HumanFactory {

    @Override
    public Human getHuman() {
        return new BlockHuman();
    }
}
