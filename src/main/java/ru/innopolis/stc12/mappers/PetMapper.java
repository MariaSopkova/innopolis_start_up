package ru.innopolis.stc12.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.stc12.pojo.Pet;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetMapper implements RowMapper<Pet> {
    @Override
    public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pet pet = new Pet();
        pet.setId(rs.getInt("pet_id"));
        pet.setName(rs.getString("name"));
        pet.setAge(rs.getInt("age"));
        pet.setGender(rs.getString("gender"));
        pet.setBreed(rs.getString("breed"));
        pet.setDateOfBirth(rs.getString("date_of_birth"));
        pet.setExhibition_id(rs.getString("exhibition_id"));
        pet.setMother_id(rs.getInt("mother_id"));
        pet.setFather_id(rs.getInt("father_id"));
        return pet;
    }
}
