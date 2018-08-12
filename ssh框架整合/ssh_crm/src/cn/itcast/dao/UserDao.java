package cn.itcast.dao;

import cn.itcast.entity.User;

public interface UserDao extends BaseDao<User> {

    User loginUser(User user);

    //void saveOrUpdate(User user);

    //List<User> findAll();

    //User findOne(int uid);

    //void delete(User user);
}
