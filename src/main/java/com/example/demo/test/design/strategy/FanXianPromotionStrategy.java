package com.example.demo.test.design.strategy;

/**
 * @Description 组合活动实现策略
 * @Date 2020/2/13 18:06
 * @Author cly
 **/
public class FanXianPromotionStrategy implements FanXianPromotionInterface {
    @Override
    public void doPromotion() {
        System.out.println("返现促销,返回的金额存放到慕课网用户的余额中");
    }

    @Override
    public void fanxian() {

    }
}
