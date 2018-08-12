package cn.itcast.dao;

import cn.itcast.entity.User;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {

    //得到hibernateTemplate对象
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    //添加操作
    @Override
    public void add() {
        //save方法
        User user = new User();
        user.setUsername("Lucy");
        user.setAddress("japan");
        hibernateTemplate.save(user);
    }

    //get方法：根据id查询
    @Override
    public void query1() {
        User user1 = hibernateTemplate.get(User.class, 3);
        System.out.println(user1.getUsername() + "::" + user1.getAddress());
    }

    //find方法查询所有记录，条件查询
    @Override
    public void query2() {
        List<User> list = (List<User>) hibernateTemplate.find("from User where username=?", "Lucy");
        for (User user : list) {
            System.out.println(user.getUsername() + "::" + user.getAddress());
        }
    }


}
