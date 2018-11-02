package ru.innopolis.stc12.mappers;


import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.stc12.pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id" ));
        user.setName(rs.getString("name" ));
        user.setFamilyName(rs.getString("family_name" ));
        user.setAge(rs.getInt("age" ));
        user.setCity(rs.getString("city" ));
        user.setEnabled(rs.getBoolean("Enabled" ));
        user.setGender(rs.getString("gender" ));
        user.setLanguage(rs.getString("language" ));
        user.setLastEnter(rs.getDate("last_enter" ));
        user.setStartDate(rs.getDate("start_date" ));
        user.setLogin(rs.getString("login" ));
        user.setPassword(rs.getString("password" ));
        user.setPetId(rs.getInt("pet_id" ));
        user.setRole(rs.getString("role" ));
        return user;
    }
}
