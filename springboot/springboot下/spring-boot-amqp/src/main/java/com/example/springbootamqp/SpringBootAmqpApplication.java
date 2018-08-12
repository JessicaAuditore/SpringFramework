package com.example.springbootamqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* 自动配置
*   1、RabbitAutoConfiguration
*   2、有自动配置了连接工厂
*   3、RabbitProperties 封装了 RabbitMQ的配置
*   4、RabbitTemplate：给RabbitMQ发生和接受消息
*   5、AmqpAdmin:RabbitMQ系统管理功能组件
*       AmpqpAdmin:创建和删除 Queue Exchange Binding
*   6、@EnableRabbit + @RabbitListener 监听消息队列的内容
* */
@SpringBootApplication
public class SpringBootAmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAmqpApplication.class, args);
    }
}
