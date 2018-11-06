package ru.innopolis.stc12.dao;
/**
 * Class for pets handler
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc12.mappers.UserMapper;
import ru.innopolis.stc12.pojo.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getUserByName(String name) {
        User user = (User) jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE user_id = ?", new Object[]{name}, new UserMapper());
        return user;
    }

    @Override
    public User getUserByFamilyname(String familyName) {
        User user = (User) jdbcTemplate.queryForObject("SELECT * FROM users WHERE family_name = ?", new Object[]{familyName}, new UserMapper());
        return user;
    }

    @Override
    public User getUserById(int id) {
        User user = (User) jdbcTemplate.queryForObject("SELECT * FROM users WHERE user_id = ?", new Object[]{id}, new UserMapper());
        return user;
    }

    @Override
    public boolean createUser(User user) {
        jdbcTemplate.update("INSERT INTO users (name, family_name , age,is_enabled,gender,role,language,password,login,city,pet_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)" );
        return true;
    }

    @Override
    public List getUsersList() {
        List<User> users = jdbcTemplate.query("SELECT * FROM users", new UserMapper());
        return users;
    }

    @Override
    public User getUserByLogin(String login) {
        User user = (User) jdbcTemplate.queryForObject("SELECT * FROM users WHERE login = ?", new Object[]{login}, new UserMapper());
        return user;
    }

    @Override
    public boolean deleteUserById(int id) {
        return false;
    }

    @Override
    public boolean deleteUserByName(String name) {
        return false;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }


}
