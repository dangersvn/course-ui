package com.example.courses_management_service.demo.activemq.demotopic;

import org.apache.activemq.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.jms.JMSException;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class TopicBroadcastConsumer1 {

    private int messageCount = 0; // Counter to simulate intermittent failure


    @JmsListener(
            destination = "broadcast.topic",
            containerFactory = "topicListenerContainerFactory1",
            concurrency = "1"
    )
    public void receiveMessage(Message message) throws JMSException {
        try {
            messageCount++;
            log.info("Current message count: " + messageCount);
            System.out.println("Broadcast Consumer 1 received: " + message.getBody(String.class));

            // Simulate an exception every other message
            if (messageCount % 2 == 0) {
                System.out.println("Simulating an exception for message " + messageCount);
                throw new RuntimeException("Simulated processing error!");
            }

            message.acknowledge();
            System.out.println("Message " + messageCount + " acknowledged.");

        } catch (RuntimeException e) {
            log.error("Error processing message: " + e.getMessage());
            //Do not acknowledge the message, it will be redelivered.
            // message.acknowledge(); //remove this line to make the message redelivered.
        } catch (JMSException e) {
            log.error("JMS Exception: " + e.getMessage());
        }
    }

    @PostConstruct
    public void init() {
        log.info("TopicBroadcastConsumer1 is READY to receive messages from broadcast.topic");
    }
}