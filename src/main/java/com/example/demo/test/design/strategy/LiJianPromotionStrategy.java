package com.example.demo.test.design.strategy;

/**
 * @Description
 * @Date 2020/2/13 18:06
 * @Author cly
 **/
public class LiJianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("立减促销,课程的价格直接减去配置的价格");
    }
}
