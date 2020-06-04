package com.example.demo.test.base.lambda;

import com.example.demo.test.base.lambda.interfaceLambda.IntPred;
import com.example.demo.test.base.lambda.interfaceLambda.InterfaceCheck;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * @Description 自定义Lambada方法
 * @Date 2020/3/18 9:06
 * @Author cly
 **/
public class LambdaInterfaceImpl {
    Logger logger= LoggerFactory.getLogger(this.getClass().getName());
    public String getLambdaInterface(LambdaInterface lambdaInterface) {
        System.out.println(lambdaInterface.defaultTest());
        System.out.println(LambdaInterface.staticTest());
        String s = "1==" + lambdaInterface.abstractTest();
        return s;
    }

    @Test
    public void test() {
        LambdaInterfaceImpl lambdaInterface = new LambdaInterfaceImpl();
        String s = lambdaInterface.getLambdaInterface(() -> {
            return "lambdaInterface";
        });
        System.out.println(s);
    }


    /**
     * @return void
     * @Author cly
     * @Description //TODO 匿名内部类，使用lambda表达式
     * @Date 9:27 2020/5/11
     * @Param []
     **/
    @Test
    public void newLambda() {
        new AnonymityLambda(() -> {
            System.out.println("");
            return "2222";
        });
    }
    @Test
    public void test2(){
        Predicate<Integer> atLeast5 = x -> x > 5;
        System.out.println(atLeast5.test(2));
        BinaryOperator<Long> addLongs = (x, y) -> x * y;
        System.out.println(addLongs.apply(1L,2L));
    }
    @Test
    public void test3(){
        InterfaceCheck interfaceCheck=new InterfaceCheck();
        //重载的check方法，lambda表达式不能推断出参数的类型--必须强制指定函数式传入的类型（IntPred）
        interfaceCheck.check((IntPred) x-> x>5);
        ///check(()->{});
    }

}
