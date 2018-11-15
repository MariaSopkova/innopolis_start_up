package ru.innopolis.stc12.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc12.dao.UserDao;
import ru.innopolis.stc12.dto.RegistrationPageDTO;
import ru.innopolis.stc12.pojo.User;

@Repository
public class RegistrationPageBDWorker {

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
