package com.atguigu.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {

    @Value("${server.port}")
    private String port;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurelaServers;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/config")
    public String getConfig() {
        String str="applicationName："+applicationName+"\t eurekaServers："+eurelaServers+"\t port："+port;
        System.out.println("*******str："+str);
        return str;
    }
}
