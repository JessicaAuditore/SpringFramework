package com.example.springbootdatajpa.repository;

import com.example.springbootdatajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository来完成对数据库的操作
public interface UserReposity extends JpaRepository<User,Integer> {


}
