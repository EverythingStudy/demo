package com.example.demo.test.MQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description RabbitMQ生产者
 * @Date 2020/3/16 14:43
 * @Author cly
 **/
@Component
public class RabbitMQPublisher {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        //24小时制
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String context = "hello " + date;
        System.out.println("Sender : " + context);
        //简单对列的情况下routingKey即为Q名
        this.rabbitTemplate.convertAndSend("q_hello", context);
    }

}
