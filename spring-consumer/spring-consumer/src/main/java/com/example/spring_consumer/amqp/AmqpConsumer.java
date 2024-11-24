package com.example.spring_consumer.amqp;

public interface AmqpConsumer<T> {

    public void consumer(T t);

}
