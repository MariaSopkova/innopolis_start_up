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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.innopolis.stc12.pojo.Pet;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.security.Actions;
import ru.innopolis.stc12.service.file.FileUploadService;
import ru.innopolis.stc12.service.pet.PetService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

@Controller
public class PetController {
    private static final Logger logger = Logger.getLogger(UserController.class);
    private PetService petService;
    private FileUploadService uploadService;

    @Autowired
    public PetController(PetService petService, FileUploadService uploadService) {
        this.petService = petService;
        this.uploadService = uploadService;
    }

    /*
     * Добавление питомца
     */
    @RequestMapping(value = "/pet/{user_id}/{id}", method = RequestMethod.POST)
    public String createOrUpdatePet(
            @PathVariable("user_id") int userId,
            @PathVariable("id") int petId,
            @RequestParam(value = "avaLink") String avaLink,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "breed") String breed,
            @RequestParam(value = "description") String description,
            @RequestParam("file") MultipartFile file,
            Model model,
            RedirectAttributes redir) {

        Pet pet = new Pet()
                .setId(petId)
                .setUser(new User().setId(userId))
                .setDateOfBirth(new Date())
                .setBreed(breed.trim())
                .setDescription(description)
                .setAvaLink(avaLink)
                .setName(name);

        String newAvaLink = uploadService.uploadMultipartFile(file);
        if (!newAvaLink.isEmpty()) {
            pet.setAvaLink(newAvaLink);
        }

        if (validatePet(model, pet) && petService.persistUserPet(pet, userId)) {
            redir.addFlashAttribute("result", "Успешно " + (petId > 0 ? "обновлено" : "добавлено"));
            return "redirect:/userpage";
        } else {
            model.addAttribute("pet", pet);
            return "petEditor";
        }
    }

    /**
     * Отображение питомца в редакторе
     *
     * @param userId Владелец питомца
     * @param petId  Питомец
     * @param model  Спринговская модель
     * @return название jsp страницы
     */
    @RequestMapping(value = "/pet/{user_id}/{id}")
    public String showPetEditor(@PathVariable("user_id") int userId, @PathVariable(value = "id") int petId, Model model) {
        Pet pet;
        if (petId > 0) {
            pet = petService.getPet(petId);
            model.addAttribute("title", "Редактирование питомца");
        } else {
            pet = new Pet();
            pet.setUser(new User().setId(userId));
            model.addAttribute("title", "Добавление питомца");
        }
        model.addAttribute("pet", pet);
        return "petEditor";
    }

    @RequestMapping(value = "/pet/remove/{id}", method = RequestMethod.DELETE)
    public String removePet(@PathVariable("id") int petId) {
        petService.removePet(petId);
        return "redirect:/userpage";
    }

    private boolean validatePet(Model model, Pet pet) {
        boolean isCorrect = true;

        if (pet.getName() == null || pet.getName().isEmpty()) {
            isCorrect = false;
            model.addAttribute("nameError", "Имя питомца обязательное");
        } else if (pet.getName() != null && pet.getName().length() > 30) {
            isCorrect = false;
            model.addAttribute("nameError",
                    "Имя питомца не должно превышать 30 символа. Сейчас " + pet.getName().length());
        }
        if (pet.getBreed() != null && pet.getBreed().length() > 30) {
            isCorrect = false;
            model.addAttribute("breedError",
                    "Название породы не должно превышать 30 символа. Сейчас " + pet.getBreed().length());
        }
        if (pet.getDescription() != null && pet.getDescription().length() > 4048) {
            isCorrect = false;
            model.addAttribute("descriptionError",
                    "Описание не должно превышать 4048 символа. Сейчас " + pet.getDescription().length());
        }
        return isCorrect;

    }


    @Secured({Actions.USER_PET_EDIT, Actions.USER_PET_VIEW})
    @PostMapping(value = "/pet/{user_id}/updatePetAvatar/{id}")
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
                Pet pet = petService.getPet(id);
                pet.setAvaLink((String) uploadResult.get("url"));
                petService.updatePet(pet);
                logger.info("Pet " + pet.getName() + " change avatar");
                model.addAttribute("pet", petService.getPet(id));
                return "redirect:/pet/{user_id}/{id}";

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
