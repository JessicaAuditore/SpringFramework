package com.example.springbootwebjsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebJspApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebJspApplication.class, args);
    }
}

/*
* jar包：执行springboot主类的main方法，启动ioc容器，创建嵌入式的servlet容器
* war包：启动服务器，服务器启动springboot应用【SpringBootServletInitializer】，启动ioc容器
* */
