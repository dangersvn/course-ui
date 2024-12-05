package com.example.courses_management_service.demo.activemq.demopointtopoint;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueWorker2 {
    @JmsListener(destination = "work.queue")
    public void processMessage(String message) {
        System.out.println("Worker 2 processed: " + message);
    }
}