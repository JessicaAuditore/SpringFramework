package com.example.springbootdatamybatis.controller;

import com.example.springbootdatamybatis.entity.Department;
import com.example.springbootdatamybatis.entity.Employee;
import com.example.springbootdatamybatis.mapper.DepartmentMapper;
import com.example.springbootdatamybatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping(value = "/dept/{id}")
    public Department getDepartment(@PathVariable(value = "id") Integer id) {
        return departmentMapper.getDeptById(id);
    }

    @GetMapping(value = "/dept")
    public Department insertDept(Department department) {
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping(value = "/emp/{id}")
    public Employee getEmp(@PathVariable(value = "id") Integer id) {
        return employeeMapper.getEmpById(id);
    }
}
