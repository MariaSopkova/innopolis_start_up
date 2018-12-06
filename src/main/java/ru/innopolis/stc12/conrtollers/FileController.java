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
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.security.Actions;
import ru.innopolis.stc12.service.UserService;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static ru.innopolis.stc12.dto.CreateGoogleFile.createGoogleFile;

@Controller
public class FileController {
    private static final Logger logger = Logger.getLogger(FileController.class);

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Secured({Actions.USER_PROFILE_EDIT, Actions.USER_PROFILE_VIEW})
    @RequestMapping(value = "/updateAvatar/{id}", method = RequestMethod.POST)
    public String uploadFile(@PathVariable("id") int id, @RequestParam("file") MultipartFile file, Model model) {// имена параметров - как на форме jsp
        String name = null;
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                name = file.getOriginalFilename();
                String rootPath = new File("").getAbsolutePath();
                File dir = new File(rootPath + File.separator + "userPhoto");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File uploadedFile = new File(dir.getAbsolutePath() + File.separator + name);
                com.google.api.services.drive.model.File googleFile = createGoogleFile(null, "image/jpeg", name, uploadedFile);
                User user = userService.getUserById(id);
                user.setAvaLink(googleFile.getWebViewLink().replace("view?usp=drivesdk","preview"));
                userService.updateUser(user);
                logger.info("User update");
                model.addAttribute("user", userService.getUserById(id));

                return "redirect:/userpage";

            } catch (Exception e) {
                logger.info(e);
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            logger.info("Error download file, becouse is empty");
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

}
