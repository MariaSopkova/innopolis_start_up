package ru.innopolis.stc12.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc12.pojo.User;

import java.util.List;

@Repository
public class UserDaoImplHibernate implements UserDao {

    private SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.session = this.sessionFactory.openSession();
    }

    @Override
    public User getUserByName(String name) {
        session.beginTransaction();
        User user = (User) session.get(User.class, name);
        session.close();
        return user;
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
        return null;
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
