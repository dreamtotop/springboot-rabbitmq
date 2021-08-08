package org.top.springbootrabbitmq.helloWorldModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue
        (value = "hello", durable = "true", autoDelete = "false", exclusive = "false"))
public class Consumer {

    private Logger logger = LoggerFactory.getLogger(Consumer.class);
    @RabbitHandler
    public void handlerMsg(String message){
        logger.info(message);
    }
}
