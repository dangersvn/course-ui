package com.example.courses_management_service.demo.activemq.demotopic;

import org.apache.activemq.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.jms.JMSException;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class TopicBroadcastConsumer2 {
    @JmsListener(
        destination = "broadcast.topic", 
        containerFactory = "topicListenerContainerFactory2",
        concurrency = "1"
    )
      public void receiveMessage(Message message) throws JMSException{
        // This message handler does not handle exepction (Check the consumer 1 for reference how to handle message properly)
        System.out.println("Broadcast Consumer 2 received: " + message.getBody(String.class));
        message.acknowledge();
        
    }

     @PostConstruct
    public void init() {
        log.info("TopicBroadcastConsumer2 is READY to receive messages from broadcast.topic");
    }
}