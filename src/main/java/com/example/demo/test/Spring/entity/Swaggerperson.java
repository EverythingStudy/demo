package com.example.demo.test.Spring.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (Swaggerperson)实体类
 *
 * @author makejava
 * @since 2020-03-05 10:57:47
 */
@ApiModel
public class Swaggerperson implements Serializable {
    private static final long serialVersionUID = -90263719320085084L;
    @ApiModelProperty("用户id")
    private Integer id;
    @ApiModelProperty("用户名")
    private String name;
    @ApiModelProperty("用户手机号")
    private String phoneNum;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

}