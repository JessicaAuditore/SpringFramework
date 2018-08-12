package cn.itcast.dao;

import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.transform.Transformers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("all")
public class CustomerImpl extends BaseImpl<Customer> implements CustomerDao {

//    //添加或保存客户
//    public void saveOrUpdate(Customer customer) {
//        this.getHibernateTemplate().saveOrUpdate(customer);
//    }

//    //提取所有客户
//    public List<Customer> findAll() {
//        return (List<Customer>) this.getHibernateTemplate().find("from Customer");
//    }

//    //根据id查询客户
//    public Customer findOne(int cid) {
//        return this.getHibernateTemplate().get(Customer.class, cid);
//    }

    //根据名字查询客户
//    public List<Customer> findSome(String custName) {
//        //第一种
////        SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
////        Session session = sessionFactory.getCurrentSession();
////        Query query = session.createQuery("from Customer where custName=?");
////        query.setParameter(0, "%" + custName + "%");
////        List<Customer> list = query.list();
//
//        //第二种:调用hibernateTemplate的find方法实现
//        //List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer where custName=?", "%" + custName + "%");
//
//        //第三种方式
//        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
//        criteria.add(Restrictions.like("custName", "%" + custName + "%"));
//        List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
//
//        return list;
//    }

//    //删除客户
//    public void delete(Customer customer) {
//        this.getHibernateTemplate().delete(customer);
//    }

    //查询记录数
    public int findCount() {
        //调用HibernateTemplate里面的find方法实现
        List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Customer");
        //从list中巴值取到
        if (list != null && list.size() != 0) {
            Object obj = list.get(0);
            //变int类型
            Long lobj = (Long) obj;
            int count = lobj.intValue();
            return count;
        }
        return 0;
    }

    //分页查询操作
    public List<Customer> findPage(int begin, int pageSize) {
//        //第一种 使用hibernate底层代码实现（了解）
//        //得到sessionFactory
//        SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
//        //得到session对象
//        Session session = sessionFactory.getCurrentSession();
//        //设置分页信息
//        Query query = session.createQuery("from Customer");
//        query.setFirstResult(begin);
//        query.setMaxResults(pageSize);
//        List<Customer> list = query.list();

        //第二种 使用离线对象和HibernateTemplate的方法实现
        //1 创建离线对象，设置对哪个实体类进行操作
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);

        //criteria.setProjection(Projections.rowCount());

        //调用hibernateTemplate的方法实现
        //第一个参数是离线对象
        //第二个参数是开始位置
        //第三个参数是每页记录数
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);


        return list;
    }

    public List<Customer> query(Customer customer) {
        String hql = "from Customer where 1=1";
        List<Object> p = new ArrayList<Object>();
        if (customer.getCustName() != null && !"".equals(customer.getCustName())) {
            hql += " and custName=?";
            p.add(customer.getCustName());
        }
        if (customer.getCustLevel().getDid() != null && !"0".equals(customer.getCustLevel().getDid())) {
            hql += " and custLevel.did=?";
            p.add(customer.getCustLevel().getDid());
        }
        if (customer.getCustSource() != null && !"null".equals(customer.getCustSource())) {
            hql += " and custSource=?";
            p.add(customer.getCustSource());
        }
        return (List<Customer>) this.getHibernateTemplate().find(hql, p.toArray());
    }

    public List<Dict> findAllDictLevel() {
        return (List<Dict>) this.getHibernateTemplate().find("from Dict");
    }

    public List findAllSource() {
        Session session = this.getSessionFactory().getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery("select custSource from ssh_crm.t_customer group by custSource;");
        return sqlQuery.list();
    }

    public List fingCountSource() {
        Session session = this.getSessionFactory().getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery("select count(*) as num,custSource from ssh_crm.t_customer group by custSource;");
        return sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class)).list();
    }

    public List fingCountLevel() {
        Session session = this.getSessionFactory().getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery("select c.num,d.dname from (select count(*) as num,custLevel from ssh_crm.t_customer group by custLevel) c,\n" +
                "ssh_crm.t_dict d where c.custLevel=d.did;");
        return sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class)).list();
    }
}
