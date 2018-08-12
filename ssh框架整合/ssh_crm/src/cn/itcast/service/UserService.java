package cn.itcast.service;

import cn.itcast.dao.UserDao;
import cn.itcast.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //登录
    public User login(User user){
        //调用dao里面的方法
        return userDao.loginUser(user);
    }

    //修改密码
    public void update(User user){
        userDao.saveOrUpdate(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findOne(int uid) {
        return userDao.findOne(uid);
    }

    public void delete(User user) {
        userDao.delete(user);
    }
}
