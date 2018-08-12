package com.example.springbootdatamybatis.mapper;

import com.example.springbootdatamybatis.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//@Mapper
public interface EmployeeMapper {

    public Employee getEmpById(@Param(value = "id") Integer id);

    public void insertEmp(Employee employee);
}
