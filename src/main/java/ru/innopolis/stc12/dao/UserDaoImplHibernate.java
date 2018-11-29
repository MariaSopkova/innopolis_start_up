package ru.innopolis.stc12.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc12.pojo.User;

import java.util.List;

@Repository
public class UserDaoImplHibernate implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUserByName(String name) {
        return null;
    }

    @Override
    public User getUserByFamilyname(String familyName) {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public boolean createUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUserById(int id) {
        return false;
    }

    @Override
    public boolean deleteUserByName(String name) {
        return false;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public List<User> getUsersList() {
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM users WHERE login = " + login;
        Query query = session.createQuery(hql);
        List<User> users = query.list();
        session.close();
        return users.get(0);
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}

