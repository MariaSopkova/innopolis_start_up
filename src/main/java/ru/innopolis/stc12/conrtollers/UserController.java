package ru.innopolis.stc12.conrtollers;

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
import ru.innopolis.stc12.security.SecurityUtils;
import ru.innopolis.stc12.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Secured(Actions.USER_PROFILE_VIEW)
    @RequestMapping(value = "/userpage", method = RequestMethod.GET)
    public String showUserPage(Model model) {
        User user = userService.getUserByLogin(SecurityUtils.getAuthenticatedUsername());
        model.addAttribute("user", user);
        return "userpage";
    }

    @Secured(Actions.USER_PROFILE_VIEW)
    @RequestMapping(value = "/userpage/{id}", method = RequestMethod.GET)
    public String showUserPage(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "userview";
    }

    /*
     * Обработка при перезходе на страницу редактирования
     * */
    @Secured({Actions.USER_PROFILE_EDIT, Actions.USER_PROFILE_VIEW})
    @RequestMapping(value = "/useredit/{id}", method = RequestMethod.GET)
    public String editUserPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "useredit";
    }

    /*
     *Обработка нажатия кнопки "Сохранить"
     */
    @Secured({Actions.USER_PROFILE_EDIT, Actions.USER_PROFILE_VIEW})
    @RequestMapping(value = "/submit/{id}", method = RequestMethod.POST)
    public String updateUser(
            @PathVariable("id") int id,
            @RequestParam(value = "firstName", required = true) String userName,
            @RequestParam(value = "lastName", required = true) String userLastNamme,
            @RequestParam(value = "city", required = true) String userCity,
            @RequestParam(value = "age", required = true) int userAge,
            Model model) {
        User user = userService.getUserById(id);
        user.setName(userName);
        user.setFamilyName(userLastNamme);
        user.setCity(userCity);
        user.setAge(userAge);
        userService.updateUser(user);
        model.addAttribute("user", userService.getUserById(id));
        return "redirect:/useredit/" + id;//собираем адрес страницы и делаем редирект. Проверяем сохранились ли данные
    }
}
