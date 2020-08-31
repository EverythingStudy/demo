package com.example.demo.test.Spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description 获取springContext容器
 * @Date 2019/11/25 15:10
 * @Author cly
 **/
@Component
public class SpringContextUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.applicationContext=applicationContext;
    }
    public  ApplicationContext getContext(){
        return applicationContext;
    }
    /**
     * 用bean组件的name来获取bean
     * @param beanName
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T>T getBean(String beanName){
        return (T) applicationContext.getBean(beanName);
    }

    /**
     * 用类来获取bean
     * @param c
     * @return
     */
    public static <T> T getBean(Class<T> c){
        return (T) applicationContext.getBean(c);
    }

    public void test(){

    }
}
