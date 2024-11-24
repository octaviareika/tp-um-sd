package com.projeto.producer.rabbit.service;

import com.projeto.producer.rabbit.DTO.Message;

public interface AmqpService {
    void sendToConsumer(Message message); // mandar a mensagem para o consumidor
}
