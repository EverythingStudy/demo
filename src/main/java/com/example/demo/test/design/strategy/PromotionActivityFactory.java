package com.example.demo.test.design.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description //打折活动工厂
 * @Date 2020/2/13 18:07
 * @Author cly
 **/
public class PromotionActivityFactory {
    private static Map<PromotionEnum,PromotionStrategy> PROMOTION_STRATEGY_MAP;

    static {
        PROMOTION_STRATEGY_MAP = new HashMap<>();
        PROMOTION_STRATEGY_MAP.put(PromotionEnum.LIJIAN,new LiJianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionEnum.FANXIAN,new FanXianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionEnum.MANJIAN,new ManJianPrommotionStrategy());
    }

    private static final PromotionStrategy NON_PROMOTION = new EmptyPromotionStrategy();

    public static PromotionStrategy getPromotionStrategy(PromotionEnum promotionKey){
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy == null ? NON_PROMOTION :promotionStrategy;

    }
}
