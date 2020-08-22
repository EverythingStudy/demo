package com.example.demo.test.interfaceTest;
/**
 * @Author cly
 * @Description //TODO 接口
 * 1.接口是特殊的抽象类
 * 2.接口方法都是抽象方法没有具体实现，编译时自动为接口里定义的方法添加public abstract修饰符
 * 3.实现类都必须实现所有方法
 * 4.实现类可以实现多个接口
 * 5.接口中的方法都是公有的
 * 6.接口中可以定义静态final的变量，实现类中Class.price使用
 * 接口保证了程序的解耦，安全,易于扩展，提高效率，“对修改封闭，对扩展开发”
 * @Date 17:49 2019/12/4
 * @Param 
 * @return 
 **/

public interface TestInterface {
    public final  static int price=13;
    public void getInterface();
}
