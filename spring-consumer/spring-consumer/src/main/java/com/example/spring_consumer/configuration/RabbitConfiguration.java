package com.example.spring_consumer.configuration;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Bean
    public MessageConverter jsonConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public SimpleRabbitListenerContainerFactory factory(ConnectionFactory connectionFactory,
    SimpleRabbitListenerContainerFactoryConfigurer configurer){
        
        SimpleRabbitListenerContainerFactory fact = new SimpleRabbitListenerContainerFactory();
        configurer.configure(fact, connectionFactory); // serve para configurar o listener
        fact.setMessageConverter(jsonConverter()); // converte a mensagem para json
        return fact;
    

    }
    
}
