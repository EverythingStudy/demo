package com.example.demo.test.design.strategy;

public enum PromotionEnum {
    LIJIAN("LIJIAN"),FANXIAN("FANXIAN"),MANJIAN("MANJIAN");

    private  String TYPE_OF_ACTIVITY;

    PromotionEnum(String TYPE_OF_ACTIVITY) {
        this.TYPE_OF_ACTIVITY = TYPE_OF_ACTIVITY;
    }

    public String getTYPE_OF_ACTIVITY() {
        return TYPE_OF_ACTIVITY;
    }
}
