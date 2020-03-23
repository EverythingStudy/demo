package com.example.demo.test.design.strategy;

/**
 * @Description
 * @Date 2020/2/13 18:07
 * @Author cly
 **/
public class EmptyPromotionStrategy implements  PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("对不起，暂无促销");
    }
}
