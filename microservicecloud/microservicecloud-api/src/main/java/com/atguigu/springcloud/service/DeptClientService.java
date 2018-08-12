package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @GetMapping(value = "/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id);

    @GetMapping(value = "/dept/list")
    public List<Dept> list();

    @PostMapping(value = "/dept/add")
    public boolean add(Dept dept);
}
