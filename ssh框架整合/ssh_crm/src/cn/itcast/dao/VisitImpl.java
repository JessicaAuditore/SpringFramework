package cn.itcast.dao;

import cn.itcast.entity.Visit;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class VisitImpl extends BaseImpl<Visit> implements VisitDao {

//    public void saveOrUpdate(Visit visit) {
//        this.getHibernateTemplate().saveOrUpdate(visit);
//    }

//    public List<Visit> findAll() {
//        return (List<Visit>) this.getHibernateTemplate().find("from Visit");
//    }

//    public Visit findOne(int vid) {
//        return this.getHibernateTemplate().get(Visit.class, vid);
//    }

//    public void delete(Visit visit) {
//        this.getHibernateTemplate().clear();
//        this.getHibernateTemplate().delete(visit);
//    }

    @Override
    public List<Visit> query(Visit visit) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Visit.class);
        if (visit.getVaddress() != null && !"".equals(visit.getVaddress())) {
            criteria.add(Restrictions.eq("vaddress", visit.getVaddress()));
        }
        if (visit.getCustomer().getCid() != null && visit.getCustomer().getCid() > 0) {
            criteria.add(Restrictions.eq("customer.cid", visit.getCustomer().getCid()));
        }
        if (visit.getUser().getUid() != null && visit.getUser().getUid() > 0) {
            criteria.add(Restrictions.eq("user.uid", visit.getUser().getUid()));
        }
        return (List<Visit>) this.getHibernateTemplate().findByCriteria(criteria);
    }
}
