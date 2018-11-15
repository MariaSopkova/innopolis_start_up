package ru.innopolis.stc12.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc12.dao.UserDao;
import ru.innopolis.stc12.dto.RegistrationPageDTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class RegistrationPageInfoCheck {
    private RegistrationPageDTO registrationInfo;
    private UserDao userDao;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

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
        return userDao.getUserByEmail(registrationInfo.getEmail()) == null;
    }

    public boolean isEmailValid(){
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(registrationInfo.getEmail());
        return matcher.matches();
    }

    public boolean isLoginUnique(){
        return userDao.getUserByLogin(registrationInfo.getLogin()) == null;
    }

    public RegistrationPageDTO getRegistrationInfo() {
        return registrationInfo;
    }
}
