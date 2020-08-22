package com.example.demo.test.ehcache;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 启用自定义的Key生成策略
 * @Date 2020/3/9 15:02
 * @Author cly
 **/
//@Configuration
public class CustomCachingConfig extends CachingConfigurerSupport {
    @Override
    public KeyGenerator keyGenerator() {
        return new CustomKeyGenerator();
    }
}
