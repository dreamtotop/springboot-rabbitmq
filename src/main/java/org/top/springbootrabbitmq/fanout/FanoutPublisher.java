package org.top.springbootrabbitmq.fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发布订阅模式
 */
@RestController
@RequestMapping("/fanout/model")
public class FanoutPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public void sendMsg(){
        rabbitTemplate.convertAndSend("logs","","fanout model message");
    }
}
