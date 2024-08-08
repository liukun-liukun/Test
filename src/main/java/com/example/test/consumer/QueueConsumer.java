package com.example.test.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QueueConsumer {

    @RabbitListener(queues = {"firstQueue"})
    public void receive(@Payload String fileBody) {
        log.info(fileBody);
    }

    @RabbitListener(queues = {"secondQueue"})
    public void receive2(@Payload String fileBody) {
        log.info("==============2=================");
        log.info(fileBody);
    }
}
