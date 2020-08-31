package com.example.demo.test.Spring.controller;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.cly.starter.AuthorCodeAutoConfigrution;
import com.example.demo.test.base.TestList;
import com.example.demo.test.Spring.entity.AdapterApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Date 2020/2/20 11:56
 * @Author cly
 **/
@RestController
@Slf4j
public class SpringAnnotation {
    @Resource
    AuthorCodeAutoConfigrution authorCodeAutoConfigrution;
    @RequestMapping
    public void getPojo(@RequestBody AdapterApi adapterApi){

    }
    @RequestMapping("testttt")
    public List<Map<String,Object>> TEST(){
        log.info(authorCodeAutoConfigrution.getAuthorCode().getAuthcode());
        log.info("tete={}","tet");
        TestList testList=new TestList();
        Map<String,Object> map=new HashMap<>();
        map.put("test","chen");
        List<Map<String,Object>> list=new ArrayList<>();
        list.add(map);
        testList.setList(list);

        return list;
    }

}
