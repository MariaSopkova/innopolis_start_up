package ru.innopolis.stc12.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.innopolis.stc12.mappers.PetMapper;
import ru.innopolis.stc12.pojo.Pet;

import java.util.List;

/**
 * Класс для доступа к данным из таблицы Pets.
 */

public class PetDaoImpl implements PetDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Pet getPetByName(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM PETS WHERE name = ?", new Object[]{name}, new PetMapper());
    }

    @Override
    public Pet getPetById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM PETS WHERE pet_id = ?", new Object[]{id}, new PetMapper());
    }

    @Override
    public int[] getIdByName(String name) {
        return new int[0];
    }

    @Override
    public boolean createPet(Pet pet) {
        return false;
    }

    @Override
    public boolean deletePetById(int id) {
        return false;
    }

    @Override
    public boolean addPet(Pet pet) {
        return false;
    }

    @Override
    public boolean updatePet(Pet pet) {
        return false;
    }

    @Override
    public List<Pet> getAllPets() {
        return null;
    }
}
