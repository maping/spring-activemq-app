package xyz.javaneverdie.springactivemq;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import xyz.javaneverdie.springactivemq.config.SpringConfig;
import xyz.javaneverdie.springactivemq.service.QueueListenerConsumerServiceImpl;

public class QueueListenerConsumerApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class);

        QueueListenerConsumerServiceImpl queueConsumer = context.getBean(QueueListenerConsumerServiceImpl.class);
        String response = queueConsumer.receiveMessage();
        System.out.println("Messgae Received = " + response);

        ((AbstractApplicationContext) context).close();
    }

}
