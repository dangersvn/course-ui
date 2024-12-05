package com.example.courses_management_service.demo.activemq.demopointtopoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import jakarta.jms.Queue;

@Component
public class QueuePointToPointProducer {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue workQueue;

    public void sendMessage(String message) {
        jmsTemplate.send(workQueue, session -> 
            session.createTextMessage(message));
    }
}
