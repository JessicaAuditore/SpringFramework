package com.example.springbootcache.dao;

import com.example.springbootcache.entity.Department;
import com.example.springbootcache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {

    @Autowired
    private DepartmentMapper departmentMapper;

    public Department getDeptById(Integer id) {
        return departmentMapper.getDeptById(id);
    }
}
