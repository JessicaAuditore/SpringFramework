package cn.itcast.service;

import cn.itcast.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserService {

    //注入dao对象
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service...............");
        userDao.add();
    }

    public void query(){
        System.out.println("service...............");
        userDao.query2();
    }


}
