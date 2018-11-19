package ru.innopolis.stc12.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.dto.RegistrationPageDTO;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.service.registration.RegistrationUserDtoAdapter;

@Service
public class RegistrationUserDaoImpl implements RegistrationUserDao {

    private UserDao userDao;

    @Autowired
    public void setUserDAO(UserDao userDao){
        this.userDao = userDao;
    }

    public boolean addUser(RegistrationPageDTO pageDTO){
        User user = RegistrationUserDtoAdapter.convertUserDtpToUserPojo(pageDTO);
        return userDao.createUser(user);
    }
}
