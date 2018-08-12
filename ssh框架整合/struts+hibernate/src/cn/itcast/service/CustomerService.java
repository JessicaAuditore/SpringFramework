package cn.itcast.service;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.CustomerDaoImpl;
import cn.itcast.entity.Customer;

import java.util.List;

public class CustomerService {

    public List<Customer> findAll() {
        CustomerDao dao = new CustomerDaoImpl();
        return dao.findAll();
    }

    public void addCustomer(Customer customer){
        CustomerDao dao = new CustomerDaoImpl();
        dao.addCustomer(customer);
    }
}
