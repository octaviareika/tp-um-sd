package com.projeto.producer.rabbit.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.producer.rabbit.DTO.Message;
import com.projeto.producer.rabbit.amqp.AmqpProducer;
import com.projeto.producer.rabbit.service.AmqpService;

@Service 
public class RabbitService implements AmqpService{

    @Autowired
    private AmqpProducer<Message> amqpProducer;

    @Override
    public void sendToConsumer(Message message) {
        amqpProducer.producer(message);
       
    }
    
}
