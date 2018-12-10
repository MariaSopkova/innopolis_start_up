package ru.innopolis.stc12.conrtollers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc12.dto.RegistrationPageDTO;
import ru.innopolis.stc12.service.registration.UserRegistrationService;

@Controller
public class RegistrationController {
    private static final Logger logger = Logger.getLogger(UserController.class);
    private UserRegistrationService registrationService;

    @Autowired
    public void setUserRegistrationService(UserRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping(value = "/registration")
    public String registrationCheck(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "surname") String surname,
            @RequestParam(value = "login") String login,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "passwordDouble") String passwordDouble,
            Model model) {
        RegistrationPageDTO user = registrationService.createRegistrationPageInfoData(firstName, surname, login, email, password, passwordDouble);
        if (!checkDataAndSetErrorFields(model, user)) {
            model.addAttribute("user", user);
            return "registration";
        }
        return addUser(user) ? "emailCheck" : "registration";
    }

    private boolean checkDataAndSetErrorFields(Model model, RegistrationPageDTO user) {
        boolean result = checkFirstName(model, user);
        result &= checkSurname(model, user);
        result &= checkPassword(model, user);
        result &= checkEmail(model, user);
        result &= checkLogin(model, user);
        return result;
    }

    private boolean checkFirstName(Model model, RegistrationPageDTO user) {
        if (registrationService.isFirstNameEmpty(user)) {
            model.addAttribute("firstNameError", "Не указано имя");
            return false;
        } else if (!registrationService.validateLength(user.getFirstName(), 30)) {
            model.addAttribute("firstNameError", "Не должно быть больше 30 символов");
            return false;
        }
        return true;
    }

    private boolean checkSurname(Model model, RegistrationPageDTO user) {
        if (registrationService.isSurnameEmpty(user)) {

            model.addAttribute("surnameError", "Не указана фамилия");
            return false;
        } else if (!registrationService.validateLength(user.getSurname(), 40)) {
            model.addAttribute("surnameError", "Не должно быть больше 40 символов");
            return false;
        }
        return true;
    }

    private boolean checkPassword(Model model, RegistrationPageDTO user) {
        boolean result = true;
        if (registrationService.isPasswordEmpty(user)) {
            model.addAttribute("passwordError", "Не введен пароль");
            result = false;
        }
        if (registrationService.isPasswordDoubleEmpty(user)) {
            model.addAttribute("passwordDoubleError", "Не введен пароль");
            result = false;
        }
        if (result && !registrationService.isPasswordEquals(user)) {
            model.addAttribute("passwordDoubleError", "Пароли не совпадают");
            result = false;
        }
        return result;
    }

    private boolean checkEmail(Model model, RegistrationPageDTO user) {
        if (registrationService.isEmailEmpty(user)) {
            model.addAttribute("emailError", "Не указан адрес почты");
            return false;
        } else if (!registrationService.isEmailValid(user)) {
            model.addAttribute("emailError", "Указан не корректный адрес электроннной почты");
            return false;
        } else if (!registrationService.isEmailUnique(user)) {
            model.addAttribute("emailError", "Данный emal уже используется");
            return false;
        } else if (!registrationService.validateLength(user.getEmail(), 256)) {
            model.addAttribute("emailError", "Не должно быть больше 256 символов");
            return false;
        }
        return true;
    }

    private boolean checkLogin(Model model, RegistrationPageDTO user) {
        if (registrationService.isLoginEmpty(user)) {
            model.addAttribute("loginError", "Не указан логин");
            return false;
        } else if (!registrationService.isLoginUnique(user)) {
            model.addAttribute("loginError", "Данный email уже используется");
            return false;
        }
        return true;
    }

    private boolean addUser(RegistrationPageDTO userDto) {
        return registrationService.addUser(userDto);
    }
}
