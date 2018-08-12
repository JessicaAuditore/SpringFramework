package cn.itcast.dao;

import java.util.List;

public interface BaseDao<T> {

    void saveOrUpdate(T t);
    //删除
    void delete(T t);
    //根据id查询
    T findOne(int id);
    //查询所有
    List<T> findAll();

    List<T> findSome(String name);
}
