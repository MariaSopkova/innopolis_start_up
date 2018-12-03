package ru.innopolis.stc12.security.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.security.Actions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class AuthUserDaoImplHibernate implements AuthUserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUserByLogin(String login) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(builder.equal(root.get("login"), login));
        Query<User> q = session.createQuery(query);
        User user = q.getSingleResult();
        session.close();
        return user;
    }

    @Override
    public List<String> getAuthorities(String login) {
        String hql = "FROM role_actions ra INNER JOIN users u ON u.role = ra.role WHERE u.login = " + login;
        String sql = "SELECT ra.action FROM role_actions ra INNER JOIN users u ON u.role = ra.role WHERE u.login = ?";
        Session session = sessionFactory.openSession();
//        Query query = session.createQuery(hql);
//        List<String> authorities = query.list();
        List<String> authorities = new ArrayList<>();
        authorities.add(Actions.USER_DASHBOARD_VIEW);
        authorities.add(Actions.USER_PROFILE_VIEW);
        authorities.add(Actions.USER_PROFILE_EDIT);
        session.close();
        return authorities;
    }
}
