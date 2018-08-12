package com.example.springboottask.controller;

import com.example.springboottask.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping(value = "/hello")
    public String hello(){
        asyncService.hello();
        return "success";
    }
}
