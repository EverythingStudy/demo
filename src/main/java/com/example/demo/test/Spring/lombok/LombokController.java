package com.example.demo.test.Spring.lombok;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Date 2020/6/5 16:58
 * @Author cly
 **/
@RestController
@Slf4j
public class LombokController {
    @RequestMapping(value = "LombokControllerTest", method = RequestMethod.GET, produces = {"application/json"})
    public List<LombokBean> lombokBeanList() {
        log.info("test=={}", "LombokControllerTest");
        List<LombokBean> lombokBeanList = new ArrayList<>();
        LombokBean lombokBean = new LombokBean();
        lombokBean.setName("test");
        lombokBean.setAge("31Y");
        lombokBeanList.add(lombokBean);
        return lombokBeanList;
    }
}

