package xyz.javaneverdie.springactivemq.service;

import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

@Service
public class QueueConsumerServiceImpl implements QueueConsumerService {

    @Autowired
    JmsTemplate jmsQueueTemplate;
    @Autowired
    MessageConverter messageConverter;

    public String receiveMessage() {
        try {
            Message message = jmsQueueTemplate.receive();
            String response = (String) messageConverter.fromMessage(message);
            return response;
        } catch (Exception exe) {
            exe.printStackTrace();
        }
        return null;
    }
}
