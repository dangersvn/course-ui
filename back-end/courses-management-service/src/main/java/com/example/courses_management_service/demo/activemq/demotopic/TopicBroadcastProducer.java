package com.example.courses_management_service.demo.activemq.demotopic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import jakarta.jms.Topic;

@Component
public class TopicBroadcastProducer {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Topic broadcastTopic;

    public void sendMessage(String message) {
        System.out.println("Broadcasting : " + broadcastTopic + " - message: " + message);
        jmsTemplate.send(broadcastTopic, session -> 
            session.createTextMessage(message));
    }
}