package xyz.javaneverdie.springactivemq;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import xyz.javaneverdie.springactivemq.config.SpringConfig;
import xyz.javaneverdie.springactivemq.service.TopicProducerService;
import xyz.javaneverdie.springactivemq.service.impl.TopicProducerServiceImpl;

public class TopicProducerApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class);
        
        TopicProducerService topicProducer = context.getBean(TopicProducerServiceImpl.class);
        topicProducer.sendMessage("Hi Forrest, How are you?");
        System.out.println("Message has been sent successfully...");

        ((AbstractApplicationContext) context).close();
    }

}
