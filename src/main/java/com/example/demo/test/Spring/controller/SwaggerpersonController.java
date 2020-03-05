package com.example.demo.test.Spring.controller;

import com.example.demo.test.Spring.entity.Swaggerperson;
import com.example.demo.test.Spring.service.SwaggerpersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * @Description 测试swager
 * @Date 2020/3/5 10:14
 * @Author cly
 **/
@RestController
@Api(value = "controller",tags={"person操作接口"})
@RequestMapping("/person")
public class SwaggerpersonController {
    /**
     * 服务对象
     */
    @Resource
    private SwaggerpersonService swaggerpersonService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne/{id}")
    @ApiOperation(value = "获取person")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "99", required = true)
    public Swaggerperson selectOne(@PathVariable Integer id) {

        //return this.swaggerpersonService.queryById(id);
        return new Swaggerperson();
    }



    @PostMapping("/addPerson")
    @ApiOperation("添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", defaultValue = "李四"),
            @ApiImplicitParam(name = "phonenum", value = "用户电话", defaultValue = "18601268533", required = true)
    }
    )
    @ApiIgnore //不想暴露此接口
    public Swaggerperson addPerson(){
        return new Swaggerperson();
    }



    @PutMapping("/{id}")
    @ApiOperation("根据id更新用户的接口")
    public Swaggerperson updateUserById(@RequestBody Swaggerperson user) {
        return user;
    }
}