package com.example.demo.test.redis.lock;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.api.sync.RedisKeyCommands;
import io.lettuce.core.api.sync.RedisStringCommands;

import java.io.IOException;
import java.util.Properties;

/**
 * @Description
 * @Date 2020/7/2 13:39
 * @Author cly
 **/
public class AbstractCommands {
    protected static RedisClient redisClient;
    protected static StatefulRedisConnection<String, String> connection;
    protected static RedisCommands<String, String> commands;
    protected static RedisStringCommands<String, String> stringCommands;
    protected static RedisAsyncCommands<String, String> asyncCommands;
    protected static RedisKeyCommands<String, String> keyCommands;

    static {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("conf.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        redisClient = RedisClient.create(properties.getProperty("redis.address"));
        connection = redisClient.connect();
        stringCommands = connection.sync();
        commands = connection.sync();
        asyncCommands = connection.async();
        keyCommands = connection.sync();
    }
}
