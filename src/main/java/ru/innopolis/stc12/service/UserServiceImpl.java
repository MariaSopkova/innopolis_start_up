package ru.innopolis.stc12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.dao.UserDao;
import ru.innopolis.stc12.pojo.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;


    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUsersList() {
        return userDao.getUsersList()
                .stream()
                .sorted(Comparator.comparingInt(User::getId))
                .collect(Collectors.toList());
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
    public void addUser(
            String name,
            String familyName,
            int age,
            boolean isEnabled,
            String gender,
            String role,
            String language,
            String password,
            String login,
            String email,
            String phone,
            String city,
            int petId,
            String avaLink,
            boolean isDeleted) {

        User newUser = new User(
                name,
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
                avaLink,
                isDeleted);

        userDao.addUser(newUser);
    }

    @Override
    public boolean deleteUserById(int id) {
        User user = getUserById(id);
        user.setDeleted(!user.isDeleted());
        return updateUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }
}
