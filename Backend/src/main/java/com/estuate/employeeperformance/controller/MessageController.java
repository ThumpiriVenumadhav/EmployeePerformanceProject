package com.estuate.employeeperformance.controller;

import org.springframework.web.bind.annotation.*;

import com.estuate.employeeperformance.messaging.RabbitMQSender;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final RabbitMQSender rabbitMQSender;

    public MessageController(RabbitMQSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        rabbitMQSender.sendMessage(message);
        return "Message sent: " + message;
    }
}

