package org.top.springbootrabbitmq.helloWorldModel;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 简单模式
 */
@RestController
@RequestMapping("/hello")
public class Publisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public void send(){
        rabbitTemplate.convertAndSend("hello", "Hello Word");
    }
}
