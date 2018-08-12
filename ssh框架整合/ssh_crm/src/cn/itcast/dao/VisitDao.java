package cn.itcast.dao;

import cn.itcast.entity.Visit;

import java.util.List;

public interface VisitDao extends BaseDao<Visit>{
    List<Visit> query(Visit visit);

//    void saveOrUpdate(Visit visit);

//    List<Visit> findAll();

//    Visit findOne(int vid);

//    void delete(Visit visit);
}
