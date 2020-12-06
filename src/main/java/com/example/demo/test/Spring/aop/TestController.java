package com.example.demo.test.Spring.aop;

import com.example.demo.test.Spring.SpringContextUtils;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 测送手动编写aop 实现切面插入
 * @Date 2019/11/25 13:09
 * @Author cly
 **/
@RestController
public class TestController implements BeanPostProcessor {
    @Resource(name = "aop1")
    ProxyService ProxyService;
    @RequestMapping("/test")
    public void getNames(){
        ProxyService.getName();
//        //手动获取spring容器
//        SpringContextUtils springContextUtils=new SpringContextUtils();
//        ApplicationContext springContext=springContextUtils.getContext();
//        ProxyService ProxyServices=SpringContextUtils.getBean("aop1");
//        ProxyServices.getName();
    }
    @RequestMapping("/age")
    public void getAges(){
        ProxyService.getAge();
    }

}
