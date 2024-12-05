package com.example.courses_management_service.demo.activemq.demopointtopoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueuePointToPointService {
    @Autowired
    private QueuePointToPointProducer producer;

    public void demonstratePointToPoint() {
        // Send multiple messages to demonstrate load balancing
        for (int i = 0; i < 5; i++) {
            producer.sendMessage("Work item " + i);
        }
    }
}