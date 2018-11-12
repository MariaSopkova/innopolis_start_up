package ru.innopolis.stc12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc12.dao.UserDao;
import ru.innopolis.stc12.dto.RegistrationPageDTO;

@Repository
public class RegistrationPageInfoCheck {
    private RegistrationPageDTO registrationInfo;
    private UserDao userDao;

    @Autowired
    public void setUserDAO(UserDao userDao){
        this.userDao = userDao;
    }

    public void setRegistrationPageInfoData(String firstName, String surname, String login, String email, String password, String passwordDouble) {
        registrationInfo = new RegistrationPageDTO(firstName, surname, login, email, password, passwordDouble);
    }

    public boolean isFirstNameEmpty(){
        return registrationInfo.getFirstName().isEmpty();
    }

    public boolean isSurnameEmpty(){
        return registrationInfo.getSurname().isEmpty();
    }

    public boolean isLoginEmpty(){
        return registrationInfo.getLogin().isEmpty();
    }

    public boolean isEmailEmpty(){
        return registrationInfo.getEmail().isEmpty();
    }

    public boolean isPasswordEmpty(){
        return registrationInfo.getPassword().isEmpty();
    }

    public boolean isPasswordDoubleEmpty(){
        return registrationInfo.getPasswordDouble().isEmpty();
    }

    public boolean isPasswordEquals() {
        return registrationInfo.getPassword().equals(registrationInfo.getPasswordDouble());
    }

    public boolean isEmailUnique(){
        return true;
    }

    public boolean isEmailValid(){
        return true;
    }

    public boolean isLoginUnique(){
        return userDao.getUserByLogin(registrationInfo.getLogin()) == null;
    }
}
