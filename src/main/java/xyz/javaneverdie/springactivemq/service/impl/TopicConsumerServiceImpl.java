package xyz.javaneverdie.springactivemq.service.impl;

import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;
import xyz.javaneverdie.springactivemq.service.TopicConsumerService;

@Service
public class TopicConsumerServiceImpl implements TopicConsumerService {

    @Autowired
    JmsTemplate jmsTopicTemplate;
    @Autowired
    MessageConverter messageConverter;

    public String receiveMessage() {
        try {
            Message message = jmsTopicTemplate.receive();
            String response = (String) messageConverter.fromMessage(message);
            return response;
        } catch (Exception exe) {
            exe.printStackTrace();
        }
        return null;
    }
}
