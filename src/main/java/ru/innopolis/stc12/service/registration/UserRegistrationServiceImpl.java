package ru.innopolis.stc12.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.dao.UserDao;
import ru.innopolis.stc12.dto.RegistrationPageDTO;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.security.model.Roles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private UserDao userDao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserDAO(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean addUser(RegistrationPageDTO userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userDto.setPasswordDouble(userDto.getPassword());
        User user = convertUserDtpToUserPojo(userDto);
        return userDao.createUser(user);
    }

    public RegistrationPageDTO createRegistrationPageInfoData(String firstName, String surname, String login, String email, String password, String passwordDouble) {
        return new RegistrationPageDTO(firstName, surname, login, email, password, passwordDouble);
    }


    public boolean isFirstNameEmpty(RegistrationPageDTO registrationInfo) {
        return registrationInfo.getFirstName().isEmpty();
    }

    public boolean isSurnameEmpty(RegistrationPageDTO registrationInfo) {
        return registrationInfo.getSurname().isEmpty();
    }

    public boolean isLoginEmpty(RegistrationPageDTO registrationInfo) {
        return registrationInfo.getLogin().isEmpty();
    }

    public boolean isEmailEmpty(RegistrationPageDTO registrationInfo) {
        return registrationInfo.getEmail().isEmpty();
    }

    public boolean isPasswordEmpty(RegistrationPageDTO registrationInfo) {
        return registrationInfo.getPassword().isEmpty();
    }

    public boolean isPasswordDoubleEmpty(RegistrationPageDTO registrationInfo) {
        return registrationInfo.getPasswordDouble().isEmpty();
    }

    public boolean isPasswordEquals(RegistrationPageDTO registrationInfo) {
        return registrationInfo.getPassword().equals(registrationInfo.getPasswordDouble());
    }

    public boolean isEmailUnique(RegistrationPageDTO registrationInfo) {
        return userDao.getUserByEmail(registrationInfo.getEmail()) == null;
    }

    public boolean isEmailValid(RegistrationPageDTO registrationInfo) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(registrationInfo.getEmail());
        return matcher.matches();
    }

    public boolean isLoginUnique(RegistrationPageDTO registrationInfo) {
        return userDao.getUserByLogin(registrationInfo.getLogin()) == null;
    }

    private User convertUserDtpToUserPojo(RegistrationPageDTO pageDTO) {
        User user = new User();
        user.setRole(Roles.ROLE_USER);
        user.setLanguage("ru");
        user.setName(pageDTO.getFirstName());
        user.setFamilyName(pageDTO.getSurname());
        user.setEmail(pageDTO.getEmail());
        user.setLogin(pageDTO.getLogin());
        user.setPassword(pageDTO.getPassword());
        user.setEnabled(true);
        return user;
    }
}
