package com.example.demo.test.Spring.mybatis;

import com.alibaba.fastjson.JSON;
import com.example.demo.test.Spring.entity.Swaggerperson;
import com.example.demo.test.Spring.service.SwaggerpersonService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Date 2020/9/4 10:00
 * @Author cly
 **/
@RestController
@Api(value = "mybatis",tags={"mybatis测试"})
public class MybatisController {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Resource
    private SwaggerpersonService swaggerpersonService;
    @RequestMapping(value = "getById/{id}")
    public void selectByMybatis(@PathVariable int id){
        Swaggerperson swaggerperson=swaggerpersonService.queryById(id);
        logger.info(JSON.toJSONString(swaggerperson));
    }
}
