package ru.innopolis.stc12.dao;

import ru.innopolis.stc12.pojo.Pet;

import java.util.List;

public interface PetDao {
    Pet getPetByName(String name);

    Pet getPetById(int id);

    int[] getIdByName(String name);

    boolean createPet(Pet pet);

    boolean deletePetById(int id);

    boolean addPet(Pet pet);

    boolean updatePet(Pet pet);

    List<Pet> getAllPets();
}
