package ru.innopolis.stc12.dao;
/**
 * Class for pets handler
 */

import org.springframework.jdbc.core.JdbcTemplate;
import ru.innopolis.stc12.mappers.UserMapper;
import ru.innopolis.stc12.pojo.User;

import javax.sql.DataSource;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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
    public List listUsers() {
        List<User> users = jdbcTemplate.query("SELECT * FROM users", new UserMapper());
        return users;
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
