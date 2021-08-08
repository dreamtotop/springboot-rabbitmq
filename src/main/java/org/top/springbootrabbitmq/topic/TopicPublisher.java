package org.top.springbootrabbitmq.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主题模式（动态路由）
 *   *： 匹配一个单词
 *   #: 匹配 0个或者多个单词
 */
@RestController
@RequestMapping("/topic/model")
public class TopicPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public void send(){
        rabbitTemplate.convertAndSend("topics","user.save","user.save路由消息");
    }
}
