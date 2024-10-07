package com.rabbitmq.controller;

import com.rabbitmq.service.MessageSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final MessageSender messageSender;

    @PostMapping("/send")
    ResponseEntity<?> send(@RequestBody String message) {
        if (message.isBlank()) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        messageSender.send(message);
        log.info("Received message: {}", message);

        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
