package ru.innopolis.stc12.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc12.pojo.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class UserDaoImplHibernate implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUserByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return getUserByCriteria(session, "name", name);
    }

    @Override
    public User getUserByFamilyname(String familyName) {
        Session session = sessionFactory.getCurrentSession();
        return getUserByCriteria(session, "family_name", familyName);
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public boolean deleteUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(new User().setId(id));
        return true;
    }

    @Override
    public boolean deleteUserByName(String name) {
        User user = getUserByName(name);
        if (user == null || user.getId() == 0) {
            return false;
        }
        return deleteUserById(user.getId());
    }

    @Override
    public boolean createUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return true;
    }

    @Override
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
    public User getUserByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        return getUserByCriteria(session, "login", login);
    }

    @Override
    public User getUserByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        return getUserByCriteria(session, "email", email);
    }

    @Override
    public boolean updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        if (user.getId() > 0) {
            session.update(user);
        }
        return true;
    }

    private User getUserByCriteria(Session session, String criteria, String value) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(builder.equal(root.get(criteria), value));
        Query<User> q = session.createQuery(query);
        List<User> resultList = q.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        return resultList.get(0);
    }
}

