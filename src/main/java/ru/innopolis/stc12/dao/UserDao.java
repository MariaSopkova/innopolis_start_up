package ru.innopolis.stc12.dao;

import ru.innopolis.stc12.pojo.User;

public interface UserDao {
    public User getUserByName();

    public User getUserBySurname();

    public User getUserById();

    public boolean update(User user);

    public boolean deleteUserById();

    public boolean deleteUserByName();

    public boolean addUser(User user);
}
