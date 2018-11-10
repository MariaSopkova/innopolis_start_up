package ru.innopolis.stc12.conrtollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc12.service.page_info.RegistrationPageInfo;

@Controller
public class RegistrationController {
    @PostMapping(value = "/registration")
    public String registrationCheck(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "surname") String surname,
            @RequestParam(value = "login") String login,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "passwordDouble") String passwordDouble,
            Model model){
        RegistrationPageInfo pageInfo = new RegistrationPageInfo(firstName, surname, login, email, password, passwordDouble);
        return checkDataAndSetErrorFields( model, pageInfo ) ? "/emailCheck" : "/registration";
    }

    private boolean checkDataAndSetErrorFields(Model model, RegistrationPageInfo registrationPageInfo){
        boolean result = checkFirstName(model, registrationPageInfo);
        result &= checkSurname(model, registrationPageInfo);
        result &= checkPassord(model, registrationPageInfo);
        result &= checkEmail(model, registrationPageInfo);
        result &= checkLogin(model, registrationPageInfo);
        return result;
    }

    private boolean checkFirstName(Model model, RegistrationPageInfo registrationPageInfo){
        if( !registrationPageInfo.isFirstNameEmpty() ) {
            return true;
        } else {
            model.addAttribute("firstNameError", "Не указано имя");
            return false;
        }
    }

    private boolean checkSurname(Model model, RegistrationPageInfo registrationPageInfo){
        if( !registrationPageInfo.isSurnameEmpty() ) {
            return true;
        } else {
            model.addAttribute("surnameError", "Не указана фамилия");
            return false;
        }
    }

    private boolean checkPassord(Model model, RegistrationPageInfo registrationPageInfo){
        boolean result = true;
        if( registrationPageInfo.isPasswordEmpty() ) {
            model.addAttribute("passwordError", "Не введен пароль");
            result = false;
        }
        if( registrationPageInfo.isPasswordDoubleEmpty() ) {
            model.addAttribute("passwordDoubleError", "Не введен пароль");
            result = false;
        }
        if( result && !registrationPageInfo.isPasswordEquals()){
            model.addAttribute("passwordDoubleError", "Пароли не совпадают");
            result = false;
        }
        return result;
    }

    private boolean checkEmail(Model model, RegistrationPageInfo registrationPageInfo){
        if( registrationPageInfo.isEmailEmpty() ){
            model.addAttribute("emailError", "Не указан адрес почты");
            return false;
        } else if (!registrationPageInfo.isEmailValid()){
            model.addAttribute("emailError", "Указан не корректный адрес электроннной почты");
            return false;
        } else if (!registrationPageInfo.isEmailUnique()){
            model.addAttribute("emailError", "Данный emal уже используется");
            return false;
        }
        return true;
    }

    private boolean checkLogin(Model model, RegistrationPageInfo registrationPageInfo){
        if( registrationPageInfo.isLoginEmpty() ){
            model.addAttribute("loginError", "Не указан логин");
            return false;
        } else if (!registrationPageInfo.isLoginUnique()){
            model.addAttribute("loginError", "Данный emal уже используется");
            return false;
        }
        return true;
    }
}
