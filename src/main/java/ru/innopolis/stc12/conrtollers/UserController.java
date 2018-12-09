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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.security.Actions;
import ru.innopolis.stc12.security.SecurityUtils;
import ru.innopolis.stc12.service.UserService;
import ru.innopolis.stc12.service.file.FileUploadService;

@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
    private UserService userService;
    private FileUploadService uploadService;

    @Autowired
    public UserController(UserService userService, FileUploadService uploadService) {
        this.userService = userService;
        this.uploadService = uploadService;
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

    @Secured(Actions.USER_PROFILE_EDIT)
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String showUserProfile(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "userpage";
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
     * Обработка нажатия кнопки "Сохранить"
     */
    @Secured({Actions.USER_PROFILE_EDIT, Actions.USER_PROFILE_VIEW})
    @RequestMapping(value = "/submit/{id}", method = RequestMethod.POST)
    public String updateUser(
            @PathVariable("id") int id,
            @RequestParam(value = "avaLink") String avaLink,
            @RequestParam(value = "firstName", required = true) String userName,
            @RequestParam(value = "lastName", required = true) String userLastNamme,
            @RequestParam(value = "city", required = true) String userCity,
            @RequestParam(value = "age", required = true) int userAge,
            @RequestParam("file") MultipartFile file,
            Model model,
            RedirectAttributes redir) {
        User user = userService.getUserById(id);
        user.setName(userName);
        user.setFamilyName(userLastNamme);
        user.setCity(userCity);
        user.setAge(userAge);
        user.setAge(userAge);
        String newAvaLink = uploadService.uploadMultipartFile(file);
        if (!newAvaLink.isEmpty()) {
            user.setAvaLink(newAvaLink);
        } else {
            user.setAvaLink(avaLink);
        }
        userService.updateUser(user);
        model.addAttribute("user", userService.getUserById(id));
        redir.addFlashAttribute("result", "Успешно сохранено");
        return "redirect:/userpage";//собираем адрес страницы и делаем редирект. Проверяем сохранились ли данные
    }
}
