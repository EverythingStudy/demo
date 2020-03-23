package com.example.demo.test.design.strategy;

/**
 * @Description
 * @Date 2020/2/13 17:36
 * @Author cly
 **/
public class ManJianPrommotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("满减促销,满200-20元");
    }
}
