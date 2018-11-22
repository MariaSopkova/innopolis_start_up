package ru.innopolis.stc12.service;

import ru.innopolis.stc12.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getUsersList();

    User getUserByLogin(String login);

    User getUserById(int id);

    void addUser(String name,
                 String familyName,
                 int age,
                 boolean isEnabled,
                 String gender,
                 String role,
                 String language,
                 String password,
                 String login,
                 String city,
                 int petId,
                 String avaLink);

    boolean deleteUserById(int id);

    boolean updateUser(User user);
}
