package com.example.courses_management_service.demo.activemq.demopointtopoint;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import jakarta.jms.Queue;

@Configuration
@EnableJms
public class QueuePointToPointConfig {

    @Bean
    public Queue workQueue() {
        return new ActiveMQQueue("work.queue");
    }
}