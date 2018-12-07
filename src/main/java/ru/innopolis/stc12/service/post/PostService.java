package ru.innopolis.stc12.service.post;

import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.pojo.UserPost;

import java.util.List;

public interface PostService {
    boolean persistUserPost(UserPost post, int userId);

    UserPost getPost(int postId);

    List<UserPost> getPostList(User user);

    void removePost(int postId);
}
