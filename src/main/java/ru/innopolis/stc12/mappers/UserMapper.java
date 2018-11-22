package ru.innopolis.stc12.mappers;


import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.stc12.pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setName(rs.getString("name"));
        user.setFamilyName(rs.getString("family_name"));
        user.setAge(rs.getInt("age"));
        user.setEnabled(rs.getBoolean("is_enabled"));
        user.setGender(rs.getString("gender"));
        user.setRole(rs.getString("role"));
        user.setLanguage(rs.getString("language"));
        user.setPassword(rs.getString("password"));
        user.setLogin(rs.getString("login"));
        user.setCity(rs.getString("city"));
        user.setPetId(rs.getInt("pet_id"));
        user.setAvaLink(rs.getString("ava_link"));
        user.setEmail(rs.getString("email"));
        user.setPhone(rs.getString("phone"));
        return user;
    }
}
