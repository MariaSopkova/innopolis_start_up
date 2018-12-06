package ru.innopolis.stc12.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc12.conrtollers.FileController;
import ru.innopolis.stc12.pojo.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImplHibernate implements UserDao {
    private static final Logger logger = Logger.getLogger(FileController.class);
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
    @Transactional
    public User getUserById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        return user;
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
    @Transactional
    public List<User> getUsersList() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        Query<User> q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public User getUserByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(builder.equal(root.get("login"), login));
        Query<User> q = session.createQuery(query);
        return q.getSingleResult();
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    @Transactional
    public boolean updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.update(user);
        }catch (Exception e){
            logger.info(e);
            return false;
        }
        finally {
            logger.info("finally close session");
            return true;
        }
    }
}

