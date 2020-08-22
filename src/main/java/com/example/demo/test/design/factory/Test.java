package com.example.demo.test.design.factory;

/**
 * @Description 抽象工厂设计模式
 * 定义：
 * 1.抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口。
 * 2.客户端(应用层)不依赖于产品类实例如何被创建，实现等细节。强调一系列相关的产品对象(属于同一产品族)一起使用创建对象需要大量重复的代码。提供一个产品类的库，所有的产品以同样的接口出现，从而使客户端不依赖于具体实现。
 * 3.理解产品族。在生活中，日常使用的家用电器如:电冰箱，空调，洗衣机可能都是一家公司生产的，海尔品牌的电冰箱，海尔品牌的空调，海尔品牌的洗衣机。这些海尔品牌的家用电器就属于一个产品族。对应下图的同一个颜色的矩形，圆形，椭圆。生产家用电器的公司不止一家，还有海信，格力…。对于同一样家用电器如空调，不同品牌的相同产品构成了一个产品等级。对应下图，相同形状但颜色不同的几何图形
 * 4.抽象工厂模式符合设计原则中的 里氏替换原则
 * @Date 2020/2/13 14:07
 * @Author cly
 **/
public class Test {
    public static void main(String[] args) {
        HumanFactory humanYellowFactory=new YellowHumanFactory();
        YellowHuman yellowHuman= (YellowHuman) humanYellowFactory.getHuman();
        System.out.println(yellowHuman.getSex());
        HumanFactory humanFactory=new BlockHumanFactory();
        BlockHuman blockHuman= (BlockHuman) humanFactory.getHuman();
        System.out.println(blockHuman.getLeg());
    }
}
