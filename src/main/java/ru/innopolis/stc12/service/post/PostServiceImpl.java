package ru.innopolis.stc12.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.dao.PostDao;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.pojo.UserPost;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostDao postDao;

    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public boolean persistUserPost(UserPost post, int userId) {
        return postDao.persistUserPost(post, userId);
    }

    @Override
    public UserPost getPost(int postId) {
        return postDao.getPost(postId);
    }

    @Override
    public List<UserPost> getPostList(User user) {
        return postDao.getPostList(user);
    }

    @Override
    public void removePost(int postId) {
        postDao.removePost(postId);
    }
}
