package cn.itcast.service;

import cn.itcast.dao.CustomerDao;
import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;
import cn.itcast.entity.PageBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CustomerService {

    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void save(Customer customer) {
        customerDao.saveOrUpdate(customer);
    }

    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    public List<Customer> findSome(String custName) {
        return customerDao.findSome(custName);
    }

    public Customer findOne(int cid) {
        return customerDao.findOne(cid);
    }

    public void delete(Customer customer) {
        customerDao.delete(customer);
    }

    public void update(Customer customer) {
        customerDao.saveOrUpdate(customer);
    }

    //封装分页数据到PageBean对象里面
    public PageBean listPage(Integer currentPage) {
        //创建PageBean对象
        PageBean pageBean = new PageBean();
        //当前页
        pageBean.setCurrentPage(currentPage);
        //总记录数
        int totalCount = customerDao.findCount();
        pageBean.setTotalCount(totalCount);
        //每页显示记录数
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        //总页数
        int totalPage = 0;
        if (totalCount % pageSize == 0) {
            totalPage = totalCount / pageSize;
        } else {
            totalPage = totalCount / pageSize + 1;
        }
        pageBean.setTotalPage(totalPage);
        //开始位置
        int begin = (currentPage - 1) * pageSize;
        //每页记录的List集合
        List<Customer> list = customerDao.findPage(begin, pageSize);
        pageBean.setList(list);

        return pageBean;
    }

    public List<Customer> query(Customer customer) {
        return customerDao.query(customer);
    }

    public List<Dict> findAllDictLevel() {
        return customerDao.findAllDictLevel();
    }

    public List findAllSource() {
        return customerDao.findAllSource();
    }

    public List fingCountSource() {
        return customerDao.fingCountSource();
    }

    public List fingCountLevel() {
        return customerDao.fingCountLevel();
    }

    public List<Customer> findPageJson(int begin, int rows) {
        return customerDao.findPage(begin, rows);
    }

    public int findCount() {
        return customerDao.findCount();
    }
}
