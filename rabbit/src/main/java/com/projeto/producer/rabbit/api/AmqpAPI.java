package com.projeto.producer.rabbit.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.producer.rabbit.DTO.Message;
import com.projeto.producer.rabbit.service.AmqpService;

@RestController
public class AmqpAPI {
    
    @Autowired
    private AmqpService amqpService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/send")
    public void sendToConsumer(@RequestBody Message message) {
        // enviar a mensagem para o consumidor
        amqpService.sendToConsumer(message);
    }
}