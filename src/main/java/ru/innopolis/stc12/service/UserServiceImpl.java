package ru.innopolis.stc12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.dao.UserDao;
import ru.innopolis.stc12.pojo.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;


    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUsersList() {
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
    public void addUser(String name, String familyName, int age, boolean isEnabled, String gender, String role, String language, String password, String login, String email, String phone, String city, int petId, String avaLink) {
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
                petId,
                avaLink);
        userDao.addUser(newUser);
    }

    @Override
    public boolean deleteUserById(int id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }
}
