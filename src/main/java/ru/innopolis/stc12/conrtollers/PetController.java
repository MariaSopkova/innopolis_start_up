package ru.innopolis.stc12.conrtollers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc12.pojo.Pet;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.service.pet.PetService;

import java.util.Date;

@Controller
public class PetController {
    private static final Logger logger = Logger.getLogger(UserController.class);
    private PetService petService;

    @Autowired
    public void setPetService(PetService petService) {
        this.petService = petService;
    }

    /*
     * Добавление питомца
     */
    @RequestMapping(value = "/pet/{user_id}/{id}", method = RequestMethod.POST)
    public String addPet(
            @PathVariable("user_id") int userId,
            @PathVariable("id") int petId,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "breed") String breed,
            @RequestParam(value = "description") String description,
            Model model) {

        Pet pet = new Pet()
                .setId(petId)
                .setUser(new User().setId(userId))
                .setDateOfBirth(new Date())
                .setBreed(breed.trim())
                .setDescription(description)
                .setName(name);

        if (validatePet(model, pet) && petService.persistUserPet(pet, userId)) {
            model.addAttribute("result", "Успешно " + (petId > 0 ? "обновлено" : "добавлено"));
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
}
