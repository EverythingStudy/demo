package com.example.demo.test.Spring.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description
 * @Date 2020/3/5 8:55
 * @Author cly
 **/
//注解开启 swagger2 功能
//这里提供一个配置类，首先通过@EnableSwagger2注解启用Swagger2
// 然后配置一个Docket Bean，这个Bean中，配置映射路径和要扫描的接口的位置，
// 在apiInfo中，主要配置一下Swagger2文档网站的信息，例如网站的title，网站的描述，联系人的信息，使用的协议等等。
//————————————————
@EnableSwagger2
@Configuration
public class Swagger2 {
    /**
     * 通过 createRestApi函数来构建一个DocketBean
     * 函数名,可以随意命名,喜欢什么命名就什么命名
     */
    @Bean
    public Docket createRestApi(){
        //控制暴露出去的路径下的实例apis
        //如果某个接口不想暴露,可以使用以下注解
        //@ApiIgnore 这样,该接口就不会暴露在 swagger2 的页面下
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.test.Spring.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());

    }

    //构建 api文档的详细信息函数
    //
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("xxx 接口文档")
                //描述
                .description("xxx后台接口文档")
                //版本号
                .version("1.0")
                //创建人
                .contact(new Contact("啊啊啊啊","blog.csdn.net","aaa@gmail.com"))
                .license("The Apache License")
                .licenseUrl("http://www.baidu.com")
                .build();
    }
}
