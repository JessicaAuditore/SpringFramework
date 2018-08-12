package com.example.springbootcache.service;

import com.example.springbootcache.entity.Employee;

public interface EmployeeService {

    Employee getEmpById(Integer integer);

    Employee updateEmp(Employee employee);

    void deleteEmp(Integer id);

    Employee getEmpByLastName(String lastName);
}
