package ru.innopolis.stc12.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.pojo.UserPost;

import java.util.List;

@Repository
@Transactional
public class PostDaoImpl implements PostDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean persistUserPost(UserPost post, int userId) {
        Session session = sessionFactory.getCurrentSession();
        if (post.getId() > 0) {
            post.setUser(new User().setId(userId));
            session.merge(post);
        } else {
            post.setUser(session.get(User.class, userId));
            session.save(post);
        }
        return true;
    }

    @Override
    public UserPost getPost(int postId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(UserPost.class, postId);
    }

    @Override
    public List<UserPost> getPostList(User user) {
        Session session = sessionFactory.getCurrentSession();
        Query<UserPost> q = session.createQuery("from UserPost", UserPost.class);
        return q.getResultList();
    }

    @Override
    public void removePost(int postId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(new UserPost().setId(postId));
    }
}
