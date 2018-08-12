package cn.itcast.dao;

import cn.itcast.entity.User;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

@SuppressWarnings("all")
public class UserDaoImpl extends BaseImpl<User> implements UserDao {

    //登录
    public User loginUser(User user) {
        //调用方法得到HibernateTemplate
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        //登录的查询操作
        //根据用户名和密码查询
        List<User> list = (List<User>) this.getHibernateTemplate().find("from User where username=? ", user.getUsername());
        //如果查询之后，没有结果，List里面没有值，根据get(下标)获取不到值，出现下标越界异常
        //判断
        if (list != null && list.size() != 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    //修改密码
//    public void saveOrUpdate(User user) {
//        this.getHibernateTemplate().saveOrUpdate(user);
//    }
//
//    public List<User> findAll() {
//        return (List<User>) this.getHibernateTemplate().find("from User");
//    }
//
//    public User findOne(int uid) {
//        return this.getHibernateTemplate().get(User.class, uid);
//    }
//
//    public void delete(User user) {
//        this.getHibernateTemplate().delete(user);
//    }
}
