package ru.innopolis.stc12.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.dao.UserDao;
import ru.innopolis.stc12.dto.RegistrationPageDTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
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

    @Override
    public boolean isFirstNameEmpty(){
        return registrationInfo.getFirstName().isEmpty();
    }

    @Override
    public boolean isSurnameEmpty(){
        return registrationInfo.getSurname().isEmpty();
    }

    @Override
    public boolean isLoginEmpty(){
        return registrationInfo.getLogin().isEmpty();
    }

    @Override
    public boolean isEmailEmpty(){
        return registrationInfo.getEmail().isEmpty();
    }

    @Override
    public boolean isPasswordEmpty(){
        return registrationInfo.getPassword().isEmpty();
    }

    @Override
    public boolean isPasswordDoubleEmpty(){
        return registrationInfo.getPasswordDouble().isEmpty();
    }

    @Override
    public boolean isPasswordEquals() {
        return registrationInfo.getPassword().equals(registrationInfo.getPasswordDouble());
    }

    @Override
    public boolean isEmailUnique(){
        return userDao.getUserByEmail(registrationInfo.getEmail()) == null;
    }

    @Override
    public boolean isEmailValid(){
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(registrationInfo.getEmail());
        return matcher.matches();
    }

    @Override
    public boolean isLoginUnique(){
        return userDao.getUserByLogin(registrationInfo.getLogin()) == null;
    }

    @Override
    public RegistrationPageDTO getRegistrationInfo() {
        return registrationInfo;
    }
}
