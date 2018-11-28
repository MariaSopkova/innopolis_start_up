package ru.innopolis.stc12.security.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc12.pojo.User;

import java.util.List;

@Repository
public class AuthUserDaoImplHibernate implements AuthUserDao {

    private SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.session = this.sessionFactory.openSession();
    }

    @Override
    public User getUserByLogin(String login) {
        session.beginTransaction();
        User user = (User) session.get(User.class, login);
        session.close();
        return user;
    }

    @Override
    public List<String> getAuthorities(String login) {
        List<String> list;
        String sql = "SELECT ra.action FROM role_actions ra INNER JOIN users u ON u.role = ra.role WHERE u.login = ?";
        session.beginTransaction();
        /*
         *
         **/
        session.close();
        return null;
    }
}
