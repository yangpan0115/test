package com.yp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.yp.pojo.Bbsuser;

public class UserDAOImpl implements IUserDAO{

    Configuration cfg = null;
    SessionFactory sessionFactory = null;//session工厂
    Session session = null;//核心session
    Transaction tx = null;//核心事物
    public UserDAOImpl(){
        cfg = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = cfg.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public static void main(String[] args) {
        new UserDAOImpl().add();
    }
    @Override
    public void add() {
        tx = session.beginTransaction();//ts开始
        Bbsuser bbsuser = new Bbsuser();
        bbsuser.setUsername("root");
        bbsuser.setPassword("root");
        session.save(bbsuser);//保存对象
        tx.commit();//事物提交，结束
    }
}
