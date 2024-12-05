package com.example.courses_management_service.demo.activemq.demotopic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class TopicBroadcastService {
    @Autowired
    private TopicBroadcastProducer producer;

    public void demonstrateBroadcast() {
        log.info("Demonstrating topic broadcast messaging");
        producer.sendMessage("Broadcast message to all subscribers");
    }
}