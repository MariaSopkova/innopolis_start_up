package ru.innopolis.stc12.conrtollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc12.dto.RegistrationPageDTO;
import ru.innopolis.stc12.service.registration.RegistrationPageBDWorker;
import ru.innopolis.stc12.service.registration.RegistrationPageInfoCheck;
import ru.innopolis.stc12.service.registration.RegistrationPasswordEncoder;

@Controller
public class RegistrationController {
    private RegistrationPageInfoCheck check;
    private RegistrationPageBDWorker registrationPageBDWorker;
    private RegistrationPasswordEncoder registationPasswordEncoder;

    @Autowired
    public void setRegistrationPageInfoCheck(RegistrationPageInfoCheck check)
    {
        this.check = check;
    }

    @Autowired
    public void setRegistrationPageBDWorker(RegistrationPageBDWorker registrationPageBDWorker) {
        this.registrationPageBDWorker = registrationPageBDWorker;
    }

    @Autowired
    public void setRegistationPasswordEncoder(RegistrationPasswordEncoder registationPasswordEncoder) {
        this.registationPasswordEncoder = registationPasswordEncoder;
    }

    @PostMapping(value = "/registration")
    public String registrationCheck(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "surname") String surname,
            @RequestParam(value = "login") String login,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "passwordDouble") String passwordDouble,
            Model model){
        check.setRegistrationPageInfoData(firstName, surname, login, email, password, passwordDouble);
        if (!checkDataAndSetErrorFields(model)){
            return "/registration";
        }
        return addUser() ? "/emailCheck" : "/registration";
    }

    private boolean checkDataAndSetErrorFields(Model model){
        boolean result = checkFirstName(model);
        result &= checkSurname(model);
        result &= checkPassord(model);
        result &= checkEmail(model);
        result &= checkLogin(model);
        return result;
    }

    private boolean checkFirstName(Model model){
        if( !check.isFirstNameEmpty() ) {
            return true;
        } else {
            model.addAttribute("firstNameError", "Не указано имя");
            return false;
        }
    }

    private boolean checkSurname(Model model){
        if( !check.isSurnameEmpty() ) {
            return true;
        } else {
            model.addAttribute("surnameError", "Не указана фамилия");
            return false;
        }
    }

    private boolean checkPassord(Model model){
        boolean result = true;
        if( check.isPasswordEmpty() ) {
            model.addAttribute("passwordError", "Не введен пароль");
            result = false;
        }
        if( check.isPasswordDoubleEmpty() ) {
            model.addAttribute("passwordDoubleError", "Не введен пароль");
            result = false;
        }
        if( result && !check.isPasswordEquals()){
            model.addAttribute("passwordDoubleError", "Пароли не совпадают");
            result = false;
        }
        return result;
    }

    private boolean checkEmail(Model model){
        if( check.isEmailEmpty() ){
            model.addAttribute("emailError", "Не указан адрес почты");
            return false;
        } else if (!check.isEmailValid()){
            model.addAttribute("emailError", "Указан не корректный адрес электроннной почты");
            return false;
        } else if (!check.isEmailUnique()){
            model.addAttribute("emailError", "Данный emal уже используется");
            return false;
        }
        return true;
    }

    private boolean checkLogin(Model model){
        if( check.isLoginEmpty() ){
            model.addAttribute("loginError", "Не указан логин");
            return false;
        } else if (!check.isLoginUnique()){
            model.addAttribute("loginError", "Данный email уже используется");
            return false;
        }
        return true;
    }

    private boolean addUser(){
        RegistrationPageDTO userDto = check.getRegistrationInfo();
        userDto.setPassword(registationPasswordEncoder.encode(userDto.getPassword()));
        userDto.setPasswordDouble(registationPasswordEncoder.encode(userDto.getPasswordDouble()));
        return registrationPageBDWorker.addUser(userDto);
    }
}
