package org.top.springbootrabbitmq.route;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 路由模式
 */
@RestController
@RequestMapping("/route/model")
public class RoutePublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public void send(){
        rabbitTemplate.convertAndSend("directs", "error", "send route key 为info的消息");
    }
}
