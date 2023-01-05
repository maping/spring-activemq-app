package xyz.javaneverdie.springactivemq.config;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageConverter;

@Configuration
@EnableJms
public class MessageConfiguration {

    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
    private static final String QUEUE_NAME = "queue-spring";
    private static final String TOPIC_NAME = "topic-spring";

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        connectionFactory.setTrustedPackages(Arrays.asList("xyz.javaneverdie.springactivemq"));
        return connectionFactory;
    }

    @Bean
    public JmsListenerContainerFactory topicContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        //core poll size=4 threads and max poll size 8 threads
        //factory.setConcurrency("4-8");
        factory.setPubSubDomain(Boolean.TRUE);
        return factory;
    }

    @Bean
    public JmsListenerContainerFactory queueContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        //core poll size=1 threads and max poll size 5 threads
        //factory.setConcurrency("1-5");
        return factory;
    }

    @Bean
    public JmsTemplate jmsQueueTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName(QUEUE_NAME);
        return template;
    }

    @Bean
    public JmsTemplate jmsTopicTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setPubSubDomain(true);
        template.setDefaultDestinationName(TOPIC_NAME);
        return template;
    }

    @Bean
    MessageConverter converter() {
        return new SimpleMessageConverter();
    }
}
