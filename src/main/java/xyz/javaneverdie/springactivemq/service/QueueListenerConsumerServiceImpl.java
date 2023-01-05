package xyz.javaneverdie.springactivemq.service;

import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

@Service
public class QueueListenerConsumerServiceImpl{

    @Autowired
    JmsTemplate jmsQueueTemplate;
    @Autowired
    MessageConverter messageConverter;

    @JmsListener(destination = "queue-spring", containerFactory = "connectionFactory")
    public String receiveMessage() {
        try {
            Message message = jmsQueueTemplate.receive();
            String response = (String) messageConverter.fromMessage(message);
            System.out.println("Received <" + response + ">");
            return response;
        } catch (Exception exe) {
            exe.printStackTrace();
        }
        return null;
    }
}
