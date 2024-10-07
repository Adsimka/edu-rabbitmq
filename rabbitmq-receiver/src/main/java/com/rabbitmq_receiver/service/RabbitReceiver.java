package com.rabbitmq_receiver.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitReceiver {

    @RabbitListener(queues = {"rabbitmq_second"})
    public void receive(String message) {
        log.info("Received message: {}", message);
    }
}

