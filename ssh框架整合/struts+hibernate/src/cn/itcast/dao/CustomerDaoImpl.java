package cn.itcast.dao;

import cn.itcast.entity.Customer;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public List<Customer> findAll() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Customer.class);
            List<Customer> list = criteria.list();
            tx.commit();
            return list;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            //sessionFactory.close();
        }
        return null;
    }

    //添加客户的方法
    @Override
    public void addCustomer(Customer customer) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            //添加代码
            //返回值：添加到数据库里面，生成id值，返回id值
            Serializable id = session.save(customer);
            if(id!=null){
                System.out.println("success");
            }else {
                System.out.println("fail");
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            //sessionFactory.close();
        }
    }
}
