package com.example.test.producter.service.impl;

import com.example.test.producter.service.SendService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SendServiceImpl implements SendService {

    private final RabbitTemplate rabbitTemplate;

    private final Queue myQueue;

    private final Queue mySecondQueue;

    @Override
    public void sendMsg(String msg) {
        rabbitTemplate.convertAndSend(myQueue.getName(), msg);

        rabbitTemplate.convertAndSend(mySecondQueue.getName(), msg);
    }

}
