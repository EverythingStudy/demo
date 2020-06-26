package com.example.demo.test.Base.innerClass;

/**
 *内部类 1.内部类的实例化方式需要外部类的支持 2.内部类可以直接调用外部类的属性和方法，外部类不能直接调用内部类方法(需要实例化)
 */
public class InnerClass {
    private String name;
    public void getName(String name){
        //外部类使用内部类的方法只能通过实例化内部类来调用，不能直接使用
        InnerClass.InnerClassTest innerClassTest=new InnerClass().new InnerClassTest();
        innerClassTest.getAge();
        System.out.println(innerClassTest.age);
        System.out.println(name);
    }
    class InnerClassTest{
        public String age="13Y";
        public void getAge(){
            //使用外部类的方法
           //getName("内部类调用");
            System.out.println("内部类");
        }
    }

    /**
     * 出现了循环引用--注释部分都打开的话
     * @param args
     */
    public static void main(String[] args) {
        InnerClass innerClass=new InnerClass();
        innerClass.getName("外部类调用");;
       // InnerClass.InnerClassTest innerClassTest=new InnerClass().new InnerClassTest();
        //innerClassTest.getAge();

    }
}

