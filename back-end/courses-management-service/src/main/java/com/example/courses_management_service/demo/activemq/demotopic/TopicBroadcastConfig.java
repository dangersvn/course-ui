package com.example.courses_management_service.demo.activemq.demotopic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Session;
import jakarta.jms.Topic;


@Configuration
@EnableJms
public class TopicBroadcastConfig {
    @Bean
    public Topic broadcastTopic() {
        return new ActiveMQTopic("broadcast.topic");
    }

    @Bean
    public JmsListenerContainerFactory<?> topicListenerContainerFactory1(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setSubscriptionDurable(true);
        factory.setPubSubDomain(true);
        factory.setAutoStartup(true);
        factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        factory.setClientId("topicConsumer1");
        return factory;
    }

    @Bean
    public JmsListenerContainerFactory<?> topicListenerContainerFactory2(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setSubscriptionDurable(true);
        factory.setPubSubDomain(true);
        factory.setAutoStartup(true);
        factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        factory.setClientId("topicConsumer2");
        return factory;
    }
}