package org.top.springbootrabbitmq.workQueues;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 公平调度消费
 */
@Component
public class WorkConsumer {

    private Logger logger = LoggerFactory.getLogger(WorkConsumer.class);

    @RabbitListener(queuesToDeclare = @Queue(value = "work"))
    public void receiveMsg1(String message){
        logger.info("work1 receive {}" ,message);
    }


    @RabbitListener(queuesToDeclare = @Queue(value = "work"))
    public void receiveMsg2(String message){
        logger.info("work2 receive {}",message);
    }
}
