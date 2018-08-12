package com.example.springbootcache.service.impl;

import com.example.springbootcache.dao.DepartmentDao;
import com.example.springbootcache.entity.Department;
import com.example.springbootcache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "dept")
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private CacheManager cacheManager;

    @Override
    @Cacheable(key = "'id:'+#id")
    public Department getDeptById(Integer id) {
        System.out.println("查询" + id + "号部门");
        return departmentDao.getDeptById(id);
    }

    @Override
    public Department getDeptById2(Integer id) {
        Cache cache = cacheManager.getCache("dept");

        if (cache.get("id2:" + id) != null) {
            return cache.get("id2:" + id, Department.class);
        }

        System.out.println("查询" + id + "号部门");
        Department department = departmentDao.getDeptById(id);
        cache.put("id2:" + id, department);

        return departmentDao.getDeptById(id);
    }
}
