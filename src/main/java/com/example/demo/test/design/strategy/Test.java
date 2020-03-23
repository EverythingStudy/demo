package com.example.demo.test.design.strategy;

/**
 * @Description 某平台有多种打折活动，如满减，立减，返现。当在判断使用合适的活动时，不可避免的判断是否是满减。如果不是，是否为立减。如果不是，是否为返现…。这段逻辑，就是if...else代码。为了优雅的实现代码，可以采用策略模式+工厂模式
 * @Date 2020/2/13 18:08
 * @Author cly
 **/
public class Test {
    public static void main(String[] args) {
        PromotionStrategy manjian = PromotionActivityFactory.getPromotionStrategy(null);
        manjian.doPromotion();
    }
}
