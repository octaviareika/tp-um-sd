package com.projeto.producer.rabbit.amqp.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.projeto.producer.rabbit.DTO.Message;
import com.projeto.producer.rabbit.amqp.AmqpProducer;

@Component
public class ProducerRabbit implements AmqpProducer<Message> {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue; // define a fila que a mensagem vai ser enviada


    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange; // define a exchange que a mensagem vai ser enviada


    @Override
    public void producer(Message message) {

        try {

            rabbitTemplate.convertAndSend(exchange, queue, message); // produz a mensagem que vai ser enviada para a fila e exchange definidas

        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }    
    
}
