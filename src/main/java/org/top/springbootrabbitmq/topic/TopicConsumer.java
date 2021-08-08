package org.top.springbootrabbitmq.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {

    private Logger logger = LoggerFactory.getLogger(TopicConsumer.class);

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
            exchange = @Exchange(value = "topics", type = ExchangeTypes.TOPIC),
            key = {"#.save", "user.*"})
    })
    public void handlerMsg1(String message){
        logger.info("TopicConsumer handlerMsg1 {}", message);
    }


    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
                    exchange = @Exchange(value = "topics", type = ExchangeTypes.TOPIC),
                    key = {"order.#"})
    })
    public void handlerMsg2(String message){
        logger.info("TopicConsumer handlerMsg2 {}", message);
    }
}
