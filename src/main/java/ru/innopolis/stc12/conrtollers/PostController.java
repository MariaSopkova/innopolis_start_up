package ru.innopolis.stc12.conrtollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.pojo.UserPost;
import ru.innopolis.stc12.service.post.PostService;
import ru.innopolis.stc12.utils.Dates;

import java.util.Date;

@Controller
public class PostController {
    private PostService postService;

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    /*
     * Добавление поста
     */
    @RequestMapping(value = "/post/{user_id}/{id}", method = RequestMethod.POST)
    public String addPost(
            @PathVariable("user_id") int userId,
            @PathVariable("id") int postId,
            @RequestParam(value = "postTitle") String postTitle,
            @RequestParam(value = "postBody") String postBody,
            @RequestParam(value = "postType") String postType,
            Model model) {

        UserPost post = new UserPost()
                .setId(postId)
                .setUser(new User().setId(userId))
                .setStartDate(new Date())
                .setEndDate(Dates.lastDate())
                .setBody(postBody)
                .setStyle(postType)
                .setTitle(postTitle);

        if (validatePost(model, post) && postService.persistUserPost(post, userId)) {
            model.addAttribute("result", "Успешно " + (postId > 0 ? "обновлено" : "добавлено"));
            return "redirect:/userpage?active=posts";
        } else {
            model.addAttribute("post", post);
            return "userPostEditor";
        }
    }

    /**
     * Получить пост по его id
     *
     * @param userId Автор поста
     * @param postId Пост
     * @param model  Спринговская модель
     * @return название jsp страницы
     */
    @RequestMapping(value = "/post/{user_id}/{id}")
    public String getPost(@PathVariable("user_id") int userId, @PathVariable(value = "id") int postId, Model model) {
        UserPost post;
        if (postId > 0) {
            post = postService.getPost(postId);
            model.addAttribute("title", "Редактирование сообщения");
        } else {
            post = new UserPost();
            post.setUser(new User().setId(userId));
            model.addAttribute("title", "Новое сообщение");
        }
        model.addAttribute("post", post);
        return "userPostEditor";
    }

    @RequestMapping(value = "/post/remove/{id}", method = RequestMethod.DELETE)
    public String removePost(@PathVariable("id") int postId) {
        postService.removePost(postId);
        return "redirect:/userpage?active=posts";
    }

    private boolean validatePost(Model model, UserPost post) {
        boolean isCorrect = true;

        if (post.getTitle() == null || post.getTitle().isEmpty()) {
            isCorrect = false;
            model.addAttribute("postTitleError", "Заголовок сообщения обязательный");
        } else if (post.getTitle() != null && post.getTitle().length() > 256) {
            isCorrect = false;
            model.addAttribute("postTitleError",
                    "Заголовок не должен превышать 256 символа. Сейчас " + post.getTitle().length());
        }
        if (post.getBody() != null && post.getBody().length() > 4048) {
            isCorrect = false;
            model.addAttribute("postBodyError",
                    "Описание не должно превышать 4048 символа. Сейчас " + post.getBody().length());
        }
        return isCorrect;
    }
}
