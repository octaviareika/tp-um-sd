package com.projeto.producer.rabbit.configuration;

import org.springframework.amqp.core.Queue;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Este código configura a infraestrutura necessária para enviar e receber mensagens no RabbitMQ, incluindo o tratamento de 
// mensagens que não podem ser processadas (dead-letter).

@Configuration
public class ProducerRabbitConfig {
    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;


    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    @Value("${spring.rabbitmq.request.deadletter.producer}")
    private String deadLetter;

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }


    @Bean
    Queue deadLetter(){
        return new Queue(deadLetter);
    }

    @Bean
    Queue queue(){
        Map<String, Object> args = new HashMap<>();

        args.put("x-dead-letter-exchange", exchange); // serve para definir a exchange que a mensagem vai ser enviada caso ela não seja processada
        args.put("x-dead-letter-routing-key", deadLetter); // serve para definir a routing key que a mensagem vai ser enviada caso ela não seja processada
        return new Queue(queue, true, false, false, args);
    }

    @Bean
    public Binding bindingQueue(){
        return BindingBuilder.bind(queue()).to(exchange()).with(queue);
    }

    @Bean
    public Binding bindingDeadLetter(){
        return BindingBuilder.bind(deadLetter()).to(exchange()).with(deadLetter);
    }
}
