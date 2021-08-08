package org.top.springbootrabbitmq.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RouteConsumer {

    private Logger logger = LoggerFactory.getLogger(RouteConsumer.class);

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
            exchange = @Exchange(value = "directs", type = ExchangeTypes.DIRECT),
            key = {"info", "error", "warn"})
    })
    public void handleMsg1(String msg){
        logger.info("handleMsg1 receive {}", msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
                    exchange = @Exchange(value = "directs", type = ExchangeTypes.DIRECT),
                    key = "info")
    })
    public void handleMsg2(String msg){
        logger.info("handleMsg2 receive {}", msg);
    }
}
