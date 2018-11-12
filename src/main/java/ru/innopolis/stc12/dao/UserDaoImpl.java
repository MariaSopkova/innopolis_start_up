package ru.innopolis.stc12.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.innopolis.stc12.mappers.StringMapper;
import ru.innopolis.stc12.mappers.UserMapper;
import ru.innopolis.stc12.pojo.User;

import java.util.List;

/**
 * Class for pets handler
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getUserByName(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE user_id = ?", new Object[]{name}, new UserMapper());
    }

    @Override
    public User getUserByFamilyname(String familyName) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE family_name = ?", new Object[]{familyName}, new UserMapper());
    }

    @Override
    public User getUserById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE user_id = ?", new Object[]{id}, new UserMapper());
    }

    @Override
    public boolean createUser(User user) {
        jdbcTemplate.update("INSERT INTO users (name, family_name , age,is_enabled,gender,role,language,password,login,city,pet_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
        return true;
    }

    @Override
    public List<User> getUsersList() {
        return jdbcTemplate.query("SELECT * FROM users", new UserMapper());
    }

    @Override
    public User getUserByLogin(String login) {
        try{
            return jdbcTemplate.queryForObject("SELECT * FROM users WHERE login = ?", new Object[]{login}, new UserMapper());
        } catch( EmptyResultDataAccessException ex ) {
            // данная ошибка возникает, когда не найдены записи по параметру
            return null;
        }
    }

    @Override
    public List<String> getAuthorities(String login) {
        String sql = "SELECT ra.action FROM role_actions ra INNER JOIN users u ON u.role = ra.role WHERE u.login = ?";
        return jdbcTemplate.query(sql, new Object[]{login}, new StringMapper());
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
