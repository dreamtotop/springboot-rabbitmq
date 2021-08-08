package org.top.springbootrabbitmq.workQueues;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 工作队列模式
 */
@RestController
@RequestMapping("/work/model")
public class WorkPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public void sendMag(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work", "work 模式" + i);
        }

    }
}
