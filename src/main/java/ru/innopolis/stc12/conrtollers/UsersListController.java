package ru.innopolis.stc12.conrtollers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.security.Actions;
import ru.innopolis.stc12.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UsersListController {
    private static final Logger logger = Logger.getLogger(UsersListController.class);
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Secured(Actions.USER_LIST_VIEW)
    @RequestMapping(value = "/userslist", method = RequestMethod.GET)
    public String showUsersListPage(Model model) {
        model.addAttribute("users", userService.getUsersList());
        return "userslist";

    }

    @RequestMapping(value = "/availableuser/{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        user.setEnabled(!user.isEnabled());
        userService.updateUser(user);
        return showUsersListPage(model);
    }

    @RequestMapping(value = "/removeuser/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") int id, Model model) {
        userService.deleteUserById(id);
        model.addAttribute("users", userService.getUsersList());
        return showUsersListPage(model);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String deleteUser(@RequestParam(value = "searchableContent") String searchableContent, Model model) {
        List<User> searchList = new ArrayList<>();

        searchList.addAll(userService.getUsersList().stream()
                .filter(a -> (a.toString().toLowerCase().contains(searchableContent.toLowerCase())))
                .collect(Collectors.toList()));

        model.addAttribute("users", searchList);
        return "userslist";
    }

}
