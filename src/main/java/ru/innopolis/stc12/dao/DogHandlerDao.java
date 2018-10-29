package ru.innopolis.stc12.dao;

import ru.innopolis.stc12.pojo.User;

public class DogHandlerDao implements UserDao {
    @Override
    public User getUserByName() {
        return null;
    }

    @Override
    public User getUserBySurname() {
        return null;
    }

    @Override
    public User getUserById() {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean deleteUserById() {
        return false;
    }

    @Override
    public boolean deleteUserByName() {
        return false;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }
}
