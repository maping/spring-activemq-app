package xyz.javaneverdie.springactivemq;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import xyz.javaneverdie.springactivemq.config.SpringConfig;
import xyz.javaneverdie.springactivemq.service.QueueProducerService;
import xyz.javaneverdie.springactivemq.service.impl.QueueProducerServiceImpl;

public class QueueProducerApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class);

        QueueProducerService queueProducer = context.getBean(QueueProducerServiceImpl.class);
        queueProducer.sendMessage("Hi Forrest, How are you?");
        System.out.println("Message has been sent successfully...");

        ((AbstractApplicationContext) context).close();
    }
}
