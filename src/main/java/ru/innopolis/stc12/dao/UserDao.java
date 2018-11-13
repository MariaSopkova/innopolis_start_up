package ru.innopolis.stc12.dao;

import ru.innopolis.stc12.pojo.User;

import java.util.List;


public interface UserDao {
    User getUserByName(String name);

    User getUserByFamilyname(String familyName);

    User getUserById(int id);

    boolean createUser(User user);

    boolean deleteUserById(int id);

    boolean deleteUserByName(String name);

    boolean addUser(User user);

    List<User> getUsersList();

    User getUserByLogin(String login);

    List<String> getAuthorities(String login);

    boolean updateUser(User user);
}
