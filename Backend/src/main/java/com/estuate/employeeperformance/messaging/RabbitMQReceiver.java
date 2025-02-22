package com.estuate.employeeperformance.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQReceiver {

    @RabbitListener(queues = "employee.queue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}

