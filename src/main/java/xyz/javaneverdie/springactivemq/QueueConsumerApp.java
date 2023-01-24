package xyz.javaneverdie.springactivemq;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import xyz.javaneverdie.springactivemq.config.SpringConfig;
import xyz.javaneverdie.springactivemq.service.QueueConsumerService;
import xyz.javaneverdie.springactivemq.service.impl.QueueConsumerServiceImpl;

public class QueueConsumerApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class);

        QueueConsumerService queueConsumer = context.getBean(QueueConsumerServiceImpl.class);
        String response = queueConsumer.receiveMessage();
        System.out.println("Messgae Received = " + response);

        ((AbstractApplicationContext) context).close();
    }

}
