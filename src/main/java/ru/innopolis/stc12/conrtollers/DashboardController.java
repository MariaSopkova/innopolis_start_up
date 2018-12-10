package ru.innopolis.stc12.conrtollers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.security.Actions;
import ru.innopolis.stc12.security.SecurityUtils;
import ru.innopolis.stc12.service.UserService;
import ru.innopolis.stc12.service.post.PostService;

@Controller
public class DashboardController {
    private static final Logger logger = Logger.getLogger(DashboardController.class);
    private UserService userService;
    private PostService postService;

    @Autowired
    public DashboardController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @Secured(Actions.USER_DASHBOARD_VIEW)
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model) {
        User user = userService.getUserByLogin(SecurityUtils.getAuthenticatedUsername());
        model.addAttribute("user", user);
        model.addAttribute("posts", postService.getPostList(user));
        return "dashboard";
    }

}
