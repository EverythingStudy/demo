package com.example.demo.test.MQ;

import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Date 2020/3/16 14:44
 * @Author cly
 **/
@Component
//bindings=@QueueBinding(),
@RabbitListener( queues = "q_hello")
public class RabbitMQConsumer {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }
}
