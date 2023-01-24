package xyz.javaneverdie.springactivemq;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import xyz.javaneverdie.springactivemq.config.SpringConfig;
import xyz.javaneverdie.springactivemq.service.TopicConsumerService;
import xyz.javaneverdie.springactivemq.service.impl.TopicConsumerServiceImpl;

public class TopicConsumerApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class);

        TopicConsumerService topicConsumer = context.getBean(TopicConsumerServiceImpl.class);
        String response = topicConsumer.receiveMessage();
        System.out.println("Messgae Received = " + response);

        ((AbstractApplicationContext) context).close();
    }

}
