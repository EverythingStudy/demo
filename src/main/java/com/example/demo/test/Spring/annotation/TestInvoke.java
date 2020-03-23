package com.example.demo.test.Spring.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

//测试自定义注解
public class TestInvoke {
    Logger logger= LoggerFactory.getLogger(TestInvoke.class.getName());
    /**
     * @Description 访问自定义方法注解 1.//得到Test对应的Class对象 2.得到对应的方法数组 3.通过方法的反射的对象，获取方法上的注解对象
     * @Date 2020/2/12 11:08
     * @Author cly
     **/
    @org.junit.Test
    public  void methodAnnotation() {
        Class test=Test.class;

        Method[] methods=test.getDeclaredMethods();
        for(Method method:methods){
            AnnotationTest annotationTest=method.getAnnotation(AnnotationTest.class);

            if(annotationTest!=null&&annotationTest.flag()){
                logger.info(method.getName());
            }else{
                logger.info(method.getName());
            }
        }
    }
    /**
     * @Description 访问自定义类注解 1.//得到Test对应的Class对象 2.得到类对象上的注解对象
     * @Date 2020/2/12 11:08
     * @Author cly
     **/
    @org.junit.Test
    public void classAnnotation(){
        Class test=Test.class;
        Controller controller= (Controller) test.getAnnotation(Controller.class);
        logger.info(controller.value());
    }
    @org.junit.Test
    public void typeAnnotation(){
        //获得类class对象
        Class test=Test.class;
        //获取所有类注解
        Annotation[] annotations=test.getAnnotations();
        for(Annotation annotation:annotations){
            if(annotation instanceof AnnotationType){
                AnnotationType annotationType=(AnnotationType)test.getAnnotation(AnnotationType.class);
                logger.info(annotationType.value());
            }
            if(annotation instanceof  Controller){
                Controller controller=(Controller)test.getAnnotation(Controller.class);
                logger.info(controller.value());
            }
        }
        //如果获取方法上注解需要先反射得到所有方法对象
        Method[] methods=test.getMethods();
        for(Method method:methods){
            Annotation[] annotationsMethod=method.getAnnotations();
            for(Annotation annotation:annotationsMethod){
                if(annotation instanceof AnnotationTest){
                    //获取特定注解的注解对象
                    AnnotationTest annotationTest=method.getAnnotation(AnnotationTest.class);
                    if(annotationTest!=null&&annotationTest.flag()){
                        logger.info(method.getName());
                    }else{
                        logger.info(method.getName());
                        //当annotationTest.flag()=false时获取参数上的注解
                       Annotation[][] annotationsFileds=method.getParameterAnnotations();
                       for (Annotation[] annotation1:annotationsFileds){
                           for(Annotation annotation2:annotation1){
                               if(annotation2 instanceof AnnotationParameter){
                                   System.out.println(((AnnotationParameter) annotation2).value());
                               }
                           }

                       }
                    }
                }
            }
        }
    }
}
