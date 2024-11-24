package com.example.spring_consumer.service.implementation;

import org.springframework.stereotype.Service;

import com.example.spring_consumer.dto.Message;
import com.example.spring_consumer.service.ConsumerService;


@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public void action(Message message) {
        System.out.println("Message received: " + message.getText());
    }
    
}

