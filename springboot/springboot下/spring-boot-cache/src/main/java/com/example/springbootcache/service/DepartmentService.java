package com.example.springbootcache.service;

import com.example.springbootcache.entity.Department;

public interface DepartmentService {

    Department getDeptById(Integer id);

    Department getDeptById2(Integer id);
}
