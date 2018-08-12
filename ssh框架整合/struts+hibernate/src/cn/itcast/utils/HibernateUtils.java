package cn.itcast.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sessionFactory=null;
    private static Configuration cfg=null;

    //静态代码块
    static {
        cfg = new Configuration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
    }

    //提供返回与本地线程绑定的session的方法
    public static Session getSessionObject(){
        return sessionFactory.getCurrentSession();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void main(String[] args){

    }
}
