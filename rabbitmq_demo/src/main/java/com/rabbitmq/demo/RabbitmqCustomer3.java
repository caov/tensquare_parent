package com.rabbitmq.demo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: tensquare_parent
 * @description: 消费者
 * @author: cf
 * @create: 2019-06-25 15:11
 */
@Component
@RabbitListener(queues = "third")
public class RabbitmqCustomer3 {

    @RabbitHandler
    public void getMessage(String message){
        System.out.println("third收到消息"+message);
    }
}
