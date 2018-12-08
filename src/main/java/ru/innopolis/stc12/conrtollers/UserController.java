package ru.innopolis.stc12.conrtollers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.security.Actions;
import ru.innopolis.stc12.security.SecurityUtils;
import ru.innopolis.stc12.service.UserService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
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
        return "redirect:/userpage";//собираем адрес страницы и делаем редирект. Проверяем сохранились ли данные
    }

    @Secured({Actions.USER_PROFILE_EDIT, Actions.USER_PROFILE_VIEW})
    @PostMapping(value = "useredit/updateAvatar/{id}")
    public String uploadFile(@PathVariable("id") int id, @RequestParam("file") MultipartFile file, Model model) {// имена параметров - как на форме jsp
        if (!file.isEmpty()) {
            try {
                File uploadFile = new File(file.getOriginalFilename());
                uploadFile.createNewFile();
                FileOutputStream fos = new FileOutputStream(uploadFile);
                fos.write(file.getBytes());
                fos.close();

                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                InputStream input = classLoader.getResourceAsStream("cloudinary.properties");
                Properties props = new Properties();
                props.load(input);

                String myCloudName = props.getProperty("cloud_name");
                String myApiKey = props.getProperty("api_key");
                String myApiSecret = props.getProperty("api_secret");

                Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", myCloudName,
                        "api_key", myApiKey,
                        "api_secret", myApiSecret));

                Map uploadResult = cloudinary.uploader().upload(uploadFile, ObjectUtils.emptyMap());
                User user = userService.getUserById(id);
                user.setAvaLink((String) uploadResult.get("url"));
                userService.updateUser(user);
                logger.info("User " + user.getName() + " " + user.getFamilyName() + " change avatar");
                model.addAttribute("user", userService.getUserById(id));
                return "redirect:/useredit/" + id;

            } catch (Exception e) {
                logger.error(e);
                return e.getMessage();
            }
        } else {
            logger.error("file is empty");
            return "file is empty";
        }
    }
}
