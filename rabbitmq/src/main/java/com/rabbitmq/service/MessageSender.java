package com.rabbitmq.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageSender {

    @Value("${queue.name}")
    private String queueName;

    private final AmqpTemplate amqpTemplate;

    public void send(String message) {
        amqpTemplate.convertAndSend(queueName, message);
    }

}
