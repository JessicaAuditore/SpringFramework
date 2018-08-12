package cn.itcast.dao;

import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;

import java.util.List;

public interface CustomerDao extends BaseDao<Customer>{

//    void saveOrUpdate(Customer customer);

//    List<Customer> findAll();

//    Customer findOne(int cid);

//    List<Customer> findSome(String custName);

//    void delete(Customer customer);

    int findCount();

    List<Customer> findPage(int begin, int pageSize);

    List<Customer> query(Customer customer);

    List<Dict> findAllDictLevel();

    List fingCountSource();

    List fingCountLevel();

    List findAllSource();
}
