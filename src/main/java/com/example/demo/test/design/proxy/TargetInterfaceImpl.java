package com.example.demo.test.design.proxy;

/**
 * @Description 目标实现类
 * @Date 2020/2/28 16:59
 * @Author cly
 **/
public class TargetInterfaceImpl implements TargetInterface {
    @Override
    public void targetMehod() {
        System.out.println("目标类方法");
    }
}
