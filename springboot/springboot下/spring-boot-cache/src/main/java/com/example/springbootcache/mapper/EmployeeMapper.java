package com.example.springbootcache.mapper;

import com.example.springbootcache.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmployeeMapper {

    Employee getEmpById(@Param(value = "id") Integer id);

    int insertEmp(Employee employee);

    void updateEmp(Employee employee);

    void deleteEmpById(@Param(value = "id") Integer integer);

    Employee getEmpByLastName(@Param(value = "lastName") String lastName);
}
