package cn.itcast.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    private Class pClass;

    public BaseImpl() {
        //第一步 得到当前运行类class
        Class aClass = this.getClass();
        //第二步 得到当前运行类的父类的参数化类型BaseImpl<T>
        Type type = aClass.getGenericSuperclass();
        //第三步 使用Type子接口ParameterizedType
        ParameterizedType ptype = (ParameterizedType) type;
        //第四步 得到实际类型参数<T>里面的T
        Type[] types = ptype.getActualTypeArguments();
        //Type接口实现类class
        pClass = (Class) types[0];
    }

    @Override
    public void saveOrUpdate(T t) {
        this.getHibernateTemplate().saveOrUpdate(t);
    }

    @Override
    public void delete(T t) {
        this.getHibernateTemplate().clear();
        this.getHibernateTemplate().delete(t);
    }

    @Override
    public T findOne(int id) {
        //不能写T.class
        return (T) this.getHibernateTemplate().get(pClass, id);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) this.getHibernateTemplate().find("from " + pClass.getSimpleName());
    }

    @Override
    public List<T> findSome(String name) {
        DetachedCriteria criteria = DetachedCriteria.forClass(pClass);
        //criteria.add(Restrictions.like());
        if (pClass.getSimpleName().toString().equals("Customer")) {
            criteria.add(Restrictions.like("custName", "%" + name + "%"));
            List<T> list = (List<T>) this.getHibernateTemplate().findByCriteria(criteria);
            return list;
        } else if (pClass.getSimpleName().toString().equals("LinkMan")) {
            criteria.add(Restrictions.like("lkmName", "%" + name + "%"));
            List<T> list = (List<T>) this.getHibernateTemplate().findByCriteria(criteria);
            return list;
        } else {
            return null;
        }
    }
}
