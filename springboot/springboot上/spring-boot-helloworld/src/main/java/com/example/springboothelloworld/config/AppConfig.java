package com.example.springboothelloworld.config;

import com.example.springboothelloworld.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//当前类是一个配置类：替代配置文件
@Configuration
public class AppConfig {

    //将方法的返回值添加到容器中；容器中这个组建默认的id就是方法名
    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
