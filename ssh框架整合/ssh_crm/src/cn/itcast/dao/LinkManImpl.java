package cn.itcast.dao;

import cn.itcast.entity.LinkMan;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

@SuppressWarnings("all")
public class LinkManImpl extends BaseImpl<LinkMan> implements LinkManDao {

//    @Override
//    public void saveOrUpdate(LinkMan linkMan) {
//        this.getHibernateTemplate().saveOrUpdate(linkMan);
//    }

//    @Override
//    public List<LinkMan> findAll() {
//        return (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
//    }

//    @Override
//    public LinkMan findOne(int lkmId) {
//        return this.getHibernateTemplate().get(LinkMan.class, lkmId);
//    }

//    @Override
//    public void delete(LinkMan linkMan) {
//        this.getHibernateTemplate().clear();
//        this.getHibernateTemplate().delete(linkMan);
//    }

//    public List<LinkMan> findSome(String lkmName) {
//        DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
//        criteria.add(Restrictions.like("lkmName", "%" + lkmName + "%"));
//        return (List<LinkMan>) this.getHibernateTemplate().findByCriteria(criteria);
//    }


    @Override
    public List<LinkMan> query(LinkMan linkMan) {
//        String hql = "from LinkMan where 1=1";
//        List<Object> p = new ArrayList<Object>();
//        if (linkMan.getLkmName() != null && !"".equals(linkMan.getLkmName())) {
//            hql += " and lkmName =?";
//            p.add(linkMan.getLkmName());
//        }
//        if (linkMan.getLkmGender() != null && !"".equals(linkMan.getLkmGender())) {
//            hql += " and lkmGender =?";
//            p.add(linkMan.getLkmGender());
//        }
//        if (linkMan.getCustomer().getCid() != null && linkMan.getCustomer().getCid() > 0) {
//            hql += " and customer.cid = ?";
//            p.add(linkMan.getCustomer().getCid());
//        }

        DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
        if (linkMan.getLkmName() != null && !"".equals(linkMan.getLkmName())) {
            criteria.add(Restrictions.eq("lkmName", linkMan.getLkmName()));
        }
        if (linkMan.getLkmGender() != null && !"".equals(linkMan.getLkmGender())) {
            criteria.add(Restrictions.eq("lkmGender", linkMan.getLkmGender()));
        }
        if (linkMan.getCustomer().getCid() != null && linkMan.getCustomer().getCid() > 0) {
            criteria.add(Restrictions.eq("customer.cid", linkMan.getCustomer().getCid()));
        }
//        return (List<LinkMan>) this.getHibernateTemplate().find(hql, p.toArray());
        return (List<LinkMan>) this.getHibernateTemplate().findByCriteria(criteria);
    }
}
