package ru.innopolis.stc12.dao;

import ru.innopolis.stc12.pojo.User;

import javax.sql.DataSource;
import java.util.List;


public interface UserDao {
    public void setDataSource(DataSource dataSource);

    public User getUserByName(String name);

    public User getUserByFamilyname(String familyName);

    public User getUserById(int id);

    public boolean createUser(User user);

    public boolean deleteUserById(int id);

    public boolean deleteUserByName(String name);

    public boolean addUser(User user);

    public List listUsers();
}
