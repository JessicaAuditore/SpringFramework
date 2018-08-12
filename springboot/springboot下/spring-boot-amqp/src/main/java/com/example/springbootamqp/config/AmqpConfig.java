package com.example.springbootamqp.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit//开启基于注解的RabbitMQ模式
@Configuration
public class AmqpConfig {

    @Bean("messageConverter")
    public MessageConverter initMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
