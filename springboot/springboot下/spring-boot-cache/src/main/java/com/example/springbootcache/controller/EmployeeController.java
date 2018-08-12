package com.example.springbootcache.controller;

import com.example.springbootcache.entity.Employee;
import com.example.springbootcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/emp/{id}")
    public Employee getEmpById(@PathVariable(value = "id") Integer id) {
        return employeeService.getEmpById(id);
    }

    @GetMapping(value = "/emp")
    public Employee updateEmp(Employee employee) {
        return employeeService.updateEmp(employee);
    }

    @GetMapping(value = "/emp/delete/{id}")
    public String deleteEmp(@PathVariable(value = "id") Integer id) {
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping(value = "/emp/lastName/{lastName}")
    public Employee getEmpByLastName(@PathVariable(value = "lastName") String lastName) {
        return employeeService.getEmpByLastName(lastName);
    }
}
