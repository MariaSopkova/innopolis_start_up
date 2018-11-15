package ru.innopolis.stc12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.dao.UserDao;
import ru.innopolis.stc12.pojo.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUsersList();
    }

    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void addUser(String name, String familyName, int age, boolean isEnabled, String gender, String role, String language, String password, String login, String email, String phone, String city, int petId) {
        User newUser = new User(name,
                familyName,
                age,
                isEnabled,
                gender,
                role,
                language,
                password,
                login,
                email,
                phone,
                city,
                petId);
        userDao.addUser(newUser);
    }
}
