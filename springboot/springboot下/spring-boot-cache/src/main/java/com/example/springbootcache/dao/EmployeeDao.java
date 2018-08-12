package com.example.springbootcache.dao;

import com.example.springbootcache.entity.Employee;
import com.example.springbootcache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee getEmpById(Integer id) {
        return employeeMapper.getEmpById(id);
    }

    public Employee updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
        return employee;
    }

    public void deleteEmp(Integer id) {
        employeeMapper.deleteEmpById(id);
    }

    public Employee getEmpByLastName(String lastName) {
        return employeeMapper.getEmpByLastName(lastName);
    }
}
