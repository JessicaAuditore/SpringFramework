package com.example.springbootcache.controller;

import com.example.springbootcache.entity.Department;
import com.example.springbootcache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/dept/{id}")
    public Department getDeptById(@PathVariable(value = "id") Integer id) {
        return departmentService.getDeptById(id);
    }

    @GetMapping(value = "/dept2/{id}")
    public Department getDeptById2(@PathVariable(value = "id") Integer id) {
        return departmentService.getDeptById2(id);
    }
}
