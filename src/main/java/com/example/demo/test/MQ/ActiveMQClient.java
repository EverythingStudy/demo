package com.example.demo.test.MQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Description
 * @Date 2019/10/31 17:26
 * @Author cly
 **/
public class ActiveMQClient {
    Connection connection = null;
    Session session = null;
    MessageProducer messageProducer = null;
    /**
     * 消息服务器的连接地址
     **/
    public static final String BROKER_URL = "tcp://192.168.174.129:61616";

    public static void main(String[] args) {
        ActiveMQClient sender = new ActiveMQClient();
        sender.sendMessage("Hello ActiveMQ.");
    }

    public void sendMessage(String msg) {
        try {
//1.创建一个连接工厂
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);

//2.创建一个连接
            connection = connectionFactory.createConnection();

//3.创建一个Session
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

//4.创建消息，此处创建了一个文本消息
            Message message = session.createTextMessage(msg);

//5.创建一个目的地
            Destination destination = session.createQueue("myQueue");

//6.创建一个消息的生产者（发送者）
            messageProducer = session.createProducer(destination);

//7.发送消息
            messageProducer.send(message);

        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
//关闭连接释放资源
                if (null != messageProducer) {
                    messageProducer.close();
                }
                if (null != session) {
                    session.close();
                }
                if (null != connection) {
                    connection.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
