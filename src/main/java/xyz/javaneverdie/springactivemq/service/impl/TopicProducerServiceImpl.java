package xyz.javaneverdie.springactivemq.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import xyz.javaneverdie.springactivemq.service.TopicProducerService;

@Service
public class TopicProducerServiceImpl implements TopicProducerService {

    @Autowired
    JmsTemplate jmsTopicTemplate;

    public void sendMessage(final String message) {
        jmsTopicTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage(message);
                return objectMessage;
            }
        });
    }
}
