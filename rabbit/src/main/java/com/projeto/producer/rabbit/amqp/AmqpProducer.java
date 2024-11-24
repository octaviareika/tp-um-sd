package com.projeto.producer.rabbit.amqp;

import org.springframework.stereotype.Component;

@Component
public interface AmqpProducer<T> {
    void producer(T msg); // serve para enviar a mensagem para a fila
}
