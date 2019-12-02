package com.example.demo.test.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 * @Author cly
 * @Description //TODO 获取spring容器实例
 * @Date 17:15 2019/4/27
 * @Param 
 * @return 
 **/

@Component
public class SpringContext implements ApplicationContextAware {

	 private static ApplicationContext applicationContext;
	    @Override
	    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	        this.applicationContext = applicationContext;
	    }
	    public static ApplicationContext getApplicationContext() {
	        return applicationContext;
	    }
	    public static Object getBean(String name) {
	        return getApplicationContext().getBean(name);
	    }
	    public static <T> T getBean(Class<T> clazz) {
	        return getApplicationContext().getBean(clazz);
	    }
	    public static <T> T getBean(String name, Class<T> clazz) {
	        return getApplicationContext().getBean(name, clazz);
	    }

}
