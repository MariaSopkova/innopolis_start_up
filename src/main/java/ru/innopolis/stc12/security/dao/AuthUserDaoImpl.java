package ru.innopolis.stc12.security.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.innopolis.stc12.mappers.StringMapper;
import ru.innopolis.stc12.mappers.UserMapper;
import ru.innopolis.stc12.pojo.User;

import java.util.List;

public class AuthUserDaoImpl implements AuthUserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getUserByLogin(String login) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE login = ?", new Object[]{login}, new UserMapper());
    }

    @Override
    public List<String> getAuthorities(String login) {
        String sql = "SELECT ra.action FROM role_actions ra INNER JOIN users u ON u.role = ra.role WHERE u.login = ?";
        return jdbcTemplate.query(sql, new Object[]{login}, new StringMapper());
    }
}
