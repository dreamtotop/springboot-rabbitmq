package org.top.springbootrabbitmq.fanout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutConsumer {

    private Logger logger = LoggerFactory.getLogger(FanoutConsumer.class);

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue, // 创建临时队列
                    exchange = @Exchange(value = "logs", type = ExchangeTypes.FANOUT)) // 绑定的交换机
    })
    public void handlerMsg1(String msg){
        logger.info("receive fanout message {}", msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue ,
                    exchange = @Exchange(value = "logs", type = ExchangeTypes.FANOUT))
    })
    public void handlerMsg2(String msg){
        logger.info("receive fanout message {}", msg);
    }
}
