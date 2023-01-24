package xyz.javaneverdie.springactivemq.service.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class TopicListener {

    @JmsListener(destination = "topic-spring", containerFactory = "topicContainerFactory")
    public void receiveMessage(String message) {
        try {
            System.out.println("##############Received <" + message + ">");
        } catch (Exception exe) {
            exe.printStackTrace();
        }
    }
}
