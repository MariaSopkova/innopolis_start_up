package ru.innopolis.stc12.conrtollers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.security.Actions;
import ru.innopolis.stc12.service.UserService;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

@Controller
public class FileController {
    private static final Logger logger = Logger.getLogger(FileController.class);

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
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

                Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "hqyl9bsuz",
                        "api_key", "547785813189331",
                        "api_secret", "lPnaz0xY2h2n8G9sZLp6zVzs6Bg"));

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
