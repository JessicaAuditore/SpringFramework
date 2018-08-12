package cn.itcast.dao;

import cn.itcast.entity.LinkMan;

import java.util.List;

public interface LinkManDao extends BaseDao<LinkMan>{
    List<LinkMan> query(LinkMan linkMan);

//    void saveOrUpdate(LinkMan linkMan);

//    List<LinkMan> findAll();

//    LinkMan findOne(int lkmId);

//    void delete(LinkMan linkMan);

//    List<LinkMan> findSome(String lkmName);
}
