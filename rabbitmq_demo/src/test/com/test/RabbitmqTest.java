package com.test;

import com.rabbitmq.demo.RabbitmqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: tensquare_parent
 * @description: 测试类
 * @author: cf
 * @create: 2019-06-25 15:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqApplication.class)
public class RabbitmqTest {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessage(){
        rabbitTemplate.convertAndSend("first","rabbit直接模式测试");
    }

    @Test
    public void sendMessage2(){
        rabbitTemplate.convertAndSend("my_ex","","rabbit分裂模式测试");
    }

    @Test
    public void sendMessage3(){
        rabbitTemplate.convertAndSend("my_topic","good.topic","rabbit主题模式测试");
    }

    @Test
    public void sendMessage4(){
        rabbitTemplate.convertAndSend("my_topic","godod.log","rabbit主题模式测试");
    }

    @Test
    public void sendMessage5(){
        rabbitTemplate.convertAndSend("my_topic","good.log","rabbit主题模式测试");
    }
}
