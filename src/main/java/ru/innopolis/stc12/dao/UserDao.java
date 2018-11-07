package ru.innopolis.stc12.dao;

import ru.innopolis.stc12.pojo.User;

import java.util.List;


public interface UserDao {
    public User getUserByName(String name);

    public User getUserByFamilyname(String familyName);

    public User getUserById(int id);

    public boolean createUser(User user);

    public boolean deleteUserById(int id);

    public boolean deleteUserByName(String name);

    public boolean addUser(User user);

    public List getUsersList();

    public User getUserByLogin(String login);
}
